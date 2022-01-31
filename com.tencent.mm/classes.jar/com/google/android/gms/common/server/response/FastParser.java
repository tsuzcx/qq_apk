package com.google.android.gms.common.server.response;

import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

public class FastParser<T extends FastJsonResponse>
{
  private static final char[] zzwv;
  private static final char[] zzww;
  private static final char[] zzwx;
  private static final char[] zzwy;
  private static final char[] zzwz;
  private static final char[] zzxa;
  private static final FastParser.zza<Integer> zzxc;
  private static final FastParser.zza<Long> zzxd;
  private static final FastParser.zza<Float> zzxe;
  private static final FastParser.zza<Double> zzxf;
  private static final FastParser.zza<Boolean> zzxg;
  private static final FastParser.zza<String> zzxh;
  private static final FastParser.zza<BigInteger> zzxi;
  private static final FastParser.zza<BigDecimal> zzxj;
  private final char[] zzwq;
  private final char[] zzwr;
  private final char[] zzws;
  private final StringBuilder zzwt;
  private final StringBuilder zzwu;
  private final Stack<Integer> zzxb;
  
  static
  {
    AppMethodBeat.i(61552);
    zzwv = new char[] { 117, 108, 108 };
    zzww = new char[] { 114, 117, 101 };
    zzwx = new char[] { 114, 117, 101, 34 };
    zzwy = new char[] { 97, 108, 115, 101 };
    zzwz = new char[] { 97, 108, 115, 101, 34 };
    zzxa = new char[] { '\n' };
    zzxc = new zza();
    zzxd = new zzb();
    zzxe = new zzc();
    zzxf = new zzd();
    zzxg = new zze();
    zzxh = new zzf();
    zzxi = new zzg();
    zzxj = new zzh();
    AppMethodBeat.o(61552);
  }
  
  public FastParser()
  {
    AppMethodBeat.i(61522);
    this.zzwq = new char[1];
    this.zzwr = new char[32];
    this.zzws = new char[1024];
    this.zzwt = new StringBuilder(32);
    this.zzwu = new StringBuilder(1024);
    this.zzxb = new Stack();
    AppMethodBeat.o(61522);
  }
  
  private final int zza(BufferedReader paramBufferedReader, char[] paramArrayOfChar)
  {
    AppMethodBeat.i(61541);
    char c = zzj(paramBufferedReader);
    if (c == 0)
    {
      paramBufferedReader = new FastParser.ParseException("Unexpected EOF");
      AppMethodBeat.o(61541);
      throw paramBufferedReader;
    }
    if (c == ',')
    {
      paramBufferedReader = new FastParser.ParseException("Missing value");
      AppMethodBeat.o(61541);
      throw paramBufferedReader;
    }
    if (c == 'n')
    {
      zzb(paramBufferedReader, zzwv);
      AppMethodBeat.o(61541);
      return 0;
    }
    paramBufferedReader.mark(1024);
    int i;
    int k;
    if (c == '"')
    {
      int j = 0;
      i = 0;
      k = j;
      if (j < paramArrayOfChar.length)
      {
        k = j;
        if (paramBufferedReader.read(paramArrayOfChar, j, 1) != -1)
        {
          c = paramArrayOfChar[j];
          if (Character.isISOControl(c))
          {
            paramBufferedReader = new FastParser.ParseException("Unexpected control character while reading string");
            AppMethodBeat.o(61541);
            throw paramBufferedReader;
          }
          if ((c == '"') && (i == 0))
          {
            paramBufferedReader.reset();
            paramBufferedReader.skip(j + 1);
            AppMethodBeat.o(61541);
            return j;
          }
          if (c == '\\') {
            if (i == 0) {
              i = 1;
            }
          }
          for (;;)
          {
            j += 1;
            break;
            i = 0;
            continue;
            i = 0;
          }
        }
      }
    }
    else
    {
      paramArrayOfChar[0] = c;
      i = 1;
      for (;;)
      {
        k = i;
        if (i >= paramArrayOfChar.length) {
          break;
        }
        k = i;
        if (paramBufferedReader.read(paramArrayOfChar, i, 1) == -1) {
          break;
        }
        if ((paramArrayOfChar[i] == '}') || (paramArrayOfChar[i] == ',') || (Character.isWhitespace(paramArrayOfChar[i])) || (paramArrayOfChar[i] == ']'))
        {
          paramBufferedReader.reset();
          paramBufferedReader.skip(i - 1);
          paramArrayOfChar[i] = '\000';
          AppMethodBeat.o(61541);
          return i;
        }
        i += 1;
      }
    }
    if (k == paramArrayOfChar.length)
    {
      paramBufferedReader = new FastParser.ParseException("Absurdly long value");
      AppMethodBeat.o(61541);
      throw paramBufferedReader;
    }
    paramBufferedReader = new FastParser.ParseException("Unexpected EOF");
    AppMethodBeat.o(61541);
    throw paramBufferedReader;
  }
  
  private final String zza(BufferedReader paramBufferedReader)
  {
    AppMethodBeat.i(61526);
    this.zzxb.push(Integer.valueOf(2));
    char c = zzj(paramBufferedReader);
    switch (c)
    {
    default: 
      paramBufferedReader = new FastParser.ParseException(19 + "Unexpected token: " + c);
      AppMethodBeat.o(61526);
      throw paramBufferedReader;
    case '}': 
      zzk(2);
      AppMethodBeat.o(61526);
      return null;
    case ']': 
      zzk(2);
      zzk(1);
      zzk(5);
      AppMethodBeat.o(61526);
      return null;
    }
    this.zzxb.push(Integer.valueOf(3));
    String str = zzb(paramBufferedReader, this.zzwr, this.zzwt, null);
    zzk(3);
    if (zzj(paramBufferedReader) != ':')
    {
      paramBufferedReader = new FastParser.ParseException("Expected key/value separator");
      AppMethodBeat.o(61526);
      throw paramBufferedReader;
    }
    AppMethodBeat.o(61526);
    return str;
  }
  
  private final String zza(BufferedReader paramBufferedReader, char[] paramArrayOfChar1, StringBuilder paramStringBuilder, char[] paramArrayOfChar2)
  {
    AppMethodBeat.i(61530);
    switch (zzj(paramBufferedReader))
    {
    default: 
      paramBufferedReader = new FastParser.ParseException("Expected string");
      AppMethodBeat.o(61530);
      throw paramBufferedReader;
    case '"': 
      paramBufferedReader = zzb(paramBufferedReader, paramArrayOfChar1, paramStringBuilder, paramArrayOfChar2);
      AppMethodBeat.o(61530);
      return paramBufferedReader;
    }
    zzb(paramBufferedReader, zzwv);
    AppMethodBeat.o(61530);
    return null;
  }
  
  private final <T extends FastJsonResponse> ArrayList<T> zza(BufferedReader paramBufferedReader, FastJsonResponse.Field<?, ?> paramField)
  {
    AppMethodBeat.i(61539);
    ArrayList localArrayList = new ArrayList();
    char c = zzj(paramBufferedReader);
    switch (c)
    {
    default: 
      paramBufferedReader = new FastParser.ParseException(19 + "Unexpected token: " + c);
      AppMethodBeat.o(61539);
      throw paramBufferedReader;
    case ']': 
      zzk(5);
      AppMethodBeat.o(61539);
      return localArrayList;
    case '{': 
      this.zzxb.push(Integer.valueOf(1));
    }
    for (;;)
    {
      try
      {
        FastJsonResponse localFastJsonResponse = paramField.newConcreteTypeInstance();
        if (!zza(paramBufferedReader, localFastJsonResponse)) {
          break;
        }
        localArrayList.add(localFastJsonResponse);
        c = zzj(paramBufferedReader);
        switch (c)
        {
        default: 
          paramBufferedReader = new FastParser.ParseException(19 + "Unexpected token: " + c);
          AppMethodBeat.o(61539);
          throw paramBufferedReader;
        }
      }
      catch (InstantiationException paramBufferedReader)
      {
        paramBufferedReader = new FastParser.ParseException("Error instantiating inner object", paramBufferedReader);
        AppMethodBeat.o(61539);
        throw paramBufferedReader;
      }
      catch (IllegalAccessException paramBufferedReader)
      {
        paramBufferedReader = new FastParser.ParseException("Error instantiating inner object", paramBufferedReader);
        AppMethodBeat.o(61539);
        throw paramBufferedReader;
      }
      zzb(paramBufferedReader, zzwv);
      zzk(5);
      AppMethodBeat.o(61539);
      return null;
      if (zzj(paramBufferedReader) != '{')
      {
        paramBufferedReader = new FastParser.ParseException("Expected start of next object in array");
        AppMethodBeat.o(61539);
        throw paramBufferedReader;
      }
      this.zzxb.push(Integer.valueOf(1));
      continue;
      zzk(5);
      AppMethodBeat.o(61539);
      return localArrayList;
    }
    AppMethodBeat.o(61539);
    return localArrayList;
  }
  
  private final <O> ArrayList<O> zza(BufferedReader paramBufferedReader, FastParser.zza<O> paramzza)
  {
    AppMethodBeat.i(61529);
    int i = zzj(paramBufferedReader);
    if (i == 110)
    {
      zzb(paramBufferedReader, zzwv);
      AppMethodBeat.o(61529);
      return null;
    }
    if (i != 91)
    {
      paramBufferedReader = new FastParser.ParseException("Expected start of array");
      AppMethodBeat.o(61529);
      throw paramBufferedReader;
    }
    this.zzxb.push(Integer.valueOf(5));
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      paramBufferedReader.mark(1024);
      switch (zzj(paramBufferedReader))
      {
      case ',': 
      default: 
        paramBufferedReader.reset();
        localArrayList.add(paramzza.zzh(this, paramBufferedReader));
      }
    }
    zzk(5);
    AppMethodBeat.o(61529);
    return localArrayList;
    paramBufferedReader = new FastParser.ParseException("Unexpected EOF");
    AppMethodBeat.o(61529);
    throw paramBufferedReader;
  }
  
  private final boolean zza(BufferedReader paramBufferedReader, FastJsonResponse paramFastJsonResponse)
  {
    AppMethodBeat.i(61525);
    Map localMap = paramFastJsonResponse.getFieldMappings();
    Object localObject2 = zza(paramBufferedReader);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      zzk(1);
      AppMethodBeat.o(61525);
      return false;
      localObject1 = null;
    }
    while (localObject1 != null)
    {
      localObject2 = (FastJsonResponse.Field)localMap.get(localObject1);
      if (localObject2 == null)
      {
        localObject1 = zzb(paramBufferedReader);
      }
      else
      {
        this.zzxb.push(Integer.valueOf(4));
        int i;
        switch (((FastJsonResponse.Field)localObject2).getTypeIn())
        {
        default: 
          i = ((FastJsonResponse.Field)localObject2).getTypeIn();
          paramBufferedReader = new FastParser.ParseException(30 + "Invalid field type " + i);
          AppMethodBeat.o(61525);
          throw paramBufferedReader;
        case 0: 
          if (((FastJsonResponse.Field)localObject2).isTypeInArray()) {
            paramFastJsonResponse.setIntegers((FastJsonResponse.Field)localObject2, zza(paramBufferedReader, zzxc));
          }
          break;
        }
        for (;;)
        {
          zzk(4);
          zzk(2);
          char c = zzj(paramBufferedReader);
          switch (c)
          {
          case '}': 
          default: 
            paramBufferedReader = new FastParser.ParseException(55 + "Expected end of object or field separator, but found: " + c);
            AppMethodBeat.o(61525);
            throw paramBufferedReader;
            paramFastJsonResponse.setInteger((FastJsonResponse.Field)localObject2, zzd(paramBufferedReader));
            continue;
            if (((FastJsonResponse.Field)localObject2).isTypeInArray())
            {
              paramFastJsonResponse.setBigIntegers((FastJsonResponse.Field)localObject2, zza(paramBufferedReader, zzxi));
            }
            else
            {
              paramFastJsonResponse.setBigInteger((FastJsonResponse.Field)localObject2, zzf(paramBufferedReader));
              continue;
              if (((FastJsonResponse.Field)localObject2).isTypeInArray())
              {
                paramFastJsonResponse.setLongs((FastJsonResponse.Field)localObject2, zza(paramBufferedReader, zzxd));
              }
              else
              {
                paramFastJsonResponse.setLong((FastJsonResponse.Field)localObject2, zze(paramBufferedReader));
                continue;
                if (((FastJsonResponse.Field)localObject2).isTypeInArray())
                {
                  paramFastJsonResponse.setFloats((FastJsonResponse.Field)localObject2, zza(paramBufferedReader, zzxe));
                }
                else
                {
                  paramFastJsonResponse.setFloat((FastJsonResponse.Field)localObject2, zzg(paramBufferedReader));
                  continue;
                  if (((FastJsonResponse.Field)localObject2).isTypeInArray())
                  {
                    paramFastJsonResponse.setDoubles((FastJsonResponse.Field)localObject2, zza(paramBufferedReader, zzxf));
                  }
                  else
                  {
                    paramFastJsonResponse.setDouble((FastJsonResponse.Field)localObject2, zzh(paramBufferedReader));
                    continue;
                    if (((FastJsonResponse.Field)localObject2).isTypeInArray())
                    {
                      paramFastJsonResponse.setBigDecimals((FastJsonResponse.Field)localObject2, zza(paramBufferedReader, zzxj));
                    }
                    else
                    {
                      paramFastJsonResponse.setBigDecimal((FastJsonResponse.Field)localObject2, zzi(paramBufferedReader));
                      continue;
                      if (((FastJsonResponse.Field)localObject2).isTypeInArray())
                      {
                        paramFastJsonResponse.setBooleans((FastJsonResponse.Field)localObject2, zza(paramBufferedReader, zzxg));
                      }
                      else
                      {
                        paramFastJsonResponse.setBoolean((FastJsonResponse.Field)localObject2, zza(paramBufferedReader, false));
                        continue;
                        if (((FastJsonResponse.Field)localObject2).isTypeInArray())
                        {
                          paramFastJsonResponse.setStrings((FastJsonResponse.Field)localObject2, zza(paramBufferedReader, zzxh));
                        }
                        else
                        {
                          paramFastJsonResponse.setString((FastJsonResponse.Field)localObject2, zzc(paramBufferedReader));
                          continue;
                          paramFastJsonResponse.setDecodedBytes((FastJsonResponse.Field)localObject2, Base64Utils.decode(zza(paramBufferedReader, this.zzws, this.zzwu, zzxa)));
                          continue;
                          paramFastJsonResponse.setDecodedBytes((FastJsonResponse.Field)localObject2, Base64Utils.decodeUrlSafe(zza(paramBufferedReader, this.zzws, this.zzwu, zzxa)));
                          continue;
                          i = zzj(paramBufferedReader);
                          if (i == 110)
                          {
                            zzb(paramBufferedReader, zzwv);
                            localObject1 = null;
                          }
                          for (;;)
                          {
                            paramFastJsonResponse.setStringMap((FastJsonResponse.Field)localObject2, (Map)localObject1);
                            break;
                            if (i != 123)
                            {
                              paramBufferedReader = new FastParser.ParseException("Expected start of a map object");
                              AppMethodBeat.o(61525);
                              throw paramBufferedReader;
                            }
                            this.zzxb.push(Integer.valueOf(1));
                            localObject1 = new HashMap();
                            do
                            {
                              for (;;)
                              {
                                switch (zzj(paramBufferedReader))
                                {
                                }
                              }
                              paramBufferedReader = new FastParser.ParseException("Unexpected EOF");
                              AppMethodBeat.o(61525);
                              throw paramBufferedReader;
                              String str = zzb(paramBufferedReader, this.zzwr, this.zzwt, null);
                              if (zzj(paramBufferedReader) != ':')
                              {
                                paramBufferedReader = String.valueOf(str);
                                if (paramBufferedReader.length() != 0) {}
                                for (paramBufferedReader = "No map value found for key ".concat(paramBufferedReader);; paramBufferedReader = new String("No map value found for key "))
                                {
                                  paramBufferedReader = new FastParser.ParseException(paramBufferedReader);
                                  AppMethodBeat.o(61525);
                                  throw paramBufferedReader;
                                }
                              }
                              if (zzj(paramBufferedReader) != '"')
                              {
                                paramBufferedReader = String.valueOf(str);
                                if (paramBufferedReader.length() != 0) {}
                                for (paramBufferedReader = "Expected String value for key ".concat(paramBufferedReader);; paramBufferedReader = new String("Expected String value for key "))
                                {
                                  paramBufferedReader = new FastParser.ParseException(paramBufferedReader);
                                  AppMethodBeat.o(61525);
                                  throw paramBufferedReader;
                                }
                              }
                              ((HashMap)localObject1).put(str, zzb(paramBufferedReader, this.zzwr, this.zzwt, null));
                              c = zzj(paramBufferedReader);
                            } while (c == ',');
                            if (c == '}')
                            {
                              zzk(1);
                            }
                            else
                            {
                              paramBufferedReader = new FastParser.ParseException(48 + "Unexpected character while parsing string map: " + c);
                              AppMethodBeat.o(61525);
                              throw paramBufferedReader;
                              zzk(1);
                            }
                          }
                          if (((FastJsonResponse.Field)localObject2).isTypeInArray())
                          {
                            i = zzj(paramBufferedReader);
                            if (i == 110)
                            {
                              zzb(paramBufferedReader, zzwv);
                              paramFastJsonResponse.addConcreteTypeArrayInternal((FastJsonResponse.Field)localObject2, ((FastJsonResponse.Field)localObject2).getOutputFieldName(), null);
                            }
                            else
                            {
                              this.zzxb.push(Integer.valueOf(5));
                              if (i != 91)
                              {
                                paramBufferedReader = new FastParser.ParseException("Expected array start");
                                AppMethodBeat.o(61525);
                                throw paramBufferedReader;
                              }
                              paramFastJsonResponse.addConcreteTypeArrayInternal((FastJsonResponse.Field)localObject2, ((FastJsonResponse.Field)localObject2).getOutputFieldName(), zza(paramBufferedReader, (FastJsonResponse.Field)localObject2));
                            }
                          }
                          else
                          {
                            i = zzj(paramBufferedReader);
                            if (i == 110)
                            {
                              zzb(paramBufferedReader, zzwv);
                              paramFastJsonResponse.addConcreteTypeInternal((FastJsonResponse.Field)localObject2, ((FastJsonResponse.Field)localObject2).getOutputFieldName(), null);
                            }
                            else
                            {
                              this.zzxb.push(Integer.valueOf(1));
                              if (i != 123)
                              {
                                paramBufferedReader = new FastParser.ParseException("Expected start of object");
                                AppMethodBeat.o(61525);
                                throw paramBufferedReader;
                              }
                              try
                              {
                                localObject1 = ((FastJsonResponse.Field)localObject2).newConcreteTypeInstance();
                                zza(paramBufferedReader, (FastJsonResponse)localObject1);
                                paramFastJsonResponse.addConcreteTypeInternal((FastJsonResponse.Field)localObject2, ((FastJsonResponse.Field)localObject2).getOutputFieldName(), (FastJsonResponse)localObject1);
                              }
                              catch (InstantiationException paramBufferedReader)
                              {
                                paramBufferedReader = new FastParser.ParseException("Error instantiating inner object", paramBufferedReader);
                                AppMethodBeat.o(61525);
                                throw paramBufferedReader;
                              }
                              catch (IllegalAccessException paramBufferedReader)
                              {
                                paramBufferedReader = new FastParser.ParseException("Error instantiating inner object", paramBufferedReader);
                                AppMethodBeat.o(61525);
                                throw paramBufferedReader;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
            break;
          }
        }
        localObject1 = zza(paramBufferedReader);
      }
    }
    paramBufferedReader = paramFastJsonResponse.getPostProcessor();
    if (paramBufferedReader != null) {
      paramBufferedReader.postProcess(paramFastJsonResponse);
    }
    zzk(1);
    AppMethodBeat.o(61525);
    return true;
  }
  
  private final boolean zza(BufferedReader paramBufferedReader, boolean paramBoolean)
  {
    AppMethodBeat.i(61535);
    for (;;)
    {
      char c = zzj(paramBufferedReader);
      char[] arrayOfChar;
      switch (c)
      {
      default: 
        paramBufferedReader = new FastParser.ParseException(19 + "Unexpected token: " + c);
        AppMethodBeat.o(61535);
        throw paramBufferedReader;
      case 'n': 
        zzb(paramBufferedReader, zzwv);
        AppMethodBeat.o(61535);
        return false;
      case 't': 
        if (paramBoolean) {}
        for (arrayOfChar = zzwx;; arrayOfChar = zzww)
        {
          zzb(paramBufferedReader, arrayOfChar);
          AppMethodBeat.o(61535);
          return true;
        }
      case 'f': 
        if (paramBoolean) {}
        for (arrayOfChar = zzwz;; arrayOfChar = zzwy)
        {
          zzb(paramBufferedReader, arrayOfChar);
          AppMethodBeat.o(61535);
          return false;
        }
      }
      if (paramBoolean)
      {
        paramBufferedReader = new FastParser.ParseException("No boolean value found in string");
        AppMethodBeat.o(61535);
        throw paramBufferedReader;
      }
      paramBoolean = true;
    }
  }
  
  private final String zzb(BufferedReader paramBufferedReader)
  {
    AppMethodBeat.i(61527);
    paramBufferedReader.mark(1024);
    int i;
    int k;
    int j;
    switch (zzj(paramBufferedReader))
    {
    default: 
      paramBufferedReader.reset();
      zza(paramBufferedReader, this.zzws);
      i = zzj(paramBufferedReader);
      switch (i)
      {
      default: 
        paramBufferedReader = new FastParser.ParseException(18 + "Unexpected token " + i);
        AppMethodBeat.o(61527);
        throw paramBufferedReader;
      }
    case '"': 
      if (paramBufferedReader.read(this.zzwq) == -1)
      {
        paramBufferedReader = new FastParser.ParseException("Unexpected EOF while parsing string");
        AppMethodBeat.o(61527);
        throw paramBufferedReader;
      }
      k = this.zzwq[0];
      j = 0;
    }
    while ((k != 34) || (j != 0))
    {
      if (k == 92) {
        if (j == 0) {
          j = 1;
        }
      }
      while (paramBufferedReader.read(this.zzwq) == -1)
      {
        paramBufferedReader = new FastParser.ParseException("Unexpected EOF while parsing string");
        AppMethodBeat.o(61527);
        throw paramBufferedReader;
        j = 0;
        continue;
        j = 0;
      }
      i = this.zzwq[0];
      if (Character.isISOControl(i))
      {
        paramBufferedReader = new FastParser.ParseException("Unexpected control character while reading string");
        AppMethodBeat.o(61527);
        throw paramBufferedReader;
        this.zzxb.push(Integer.valueOf(1));
        paramBufferedReader.mark(32);
        i = zzj(paramBufferedReader);
        if (i == 125)
        {
          zzk(1);
          break;
        }
        if (i == 34)
        {
          paramBufferedReader.reset();
          zza(paramBufferedReader);
          while (zzb(paramBufferedReader) != null) {}
          zzk(1);
          break;
        }
        paramBufferedReader = new FastParser.ParseException(18 + "Unexpected token " + i);
        AppMethodBeat.o(61527);
        throw paramBufferedReader;
        this.zzxb.push(Integer.valueOf(5));
        paramBufferedReader.mark(32);
        if (zzj(paramBufferedReader) == ']')
        {
          zzk(5);
          break;
        }
        paramBufferedReader.reset();
        k = 1;
        int n = 0;
        j = 0;
        label440:
        int m;
        if (k > 0)
        {
          i = zzj(paramBufferedReader);
          if (i == 0)
          {
            paramBufferedReader = new FastParser.ParseException("Unexpected EOF while parsing array");
            AppMethodBeat.o(61527);
            throw paramBufferedReader;
          }
          if (Character.isISOControl(i))
          {
            paramBufferedReader = new FastParser.ParseException("Unexpected control character while reading array");
            AppMethodBeat.o(61527);
            throw paramBufferedReader;
          }
          m = n;
          if (i == 34)
          {
            m = n;
            if (j == 0)
            {
              if (n != 0) {
                break label584;
              }
              m = 1;
            }
          }
          label526:
          if ((i != 91) || (m != 0)) {
            break label665;
          }
          k += 1;
        }
        label665:
        for (;;)
        {
          if ((i == 93) && (m == 0)) {
            k -= 1;
          }
          for (;;)
          {
            if ((i == 92) && (m != 0))
            {
              if (j == 0) {}
              for (j = 1;; j = 0)
              {
                n = m;
                break;
                label584:
                m = 0;
                break label526;
              }
            }
            j = 0;
            n = m;
            break label440;
            zzk(5);
            break;
            paramBufferedReader = new FastParser.ParseException("Missing value");
            AppMethodBeat.o(61527);
            throw paramBufferedReader;
            zzk(2);
            paramBufferedReader = zza(paramBufferedReader);
            AppMethodBeat.o(61527);
            return paramBufferedReader;
            zzk(2);
            AppMethodBeat.o(61527);
            return null;
          }
        }
      }
      k = i;
    }
  }
  
  private static String zzb(BufferedReader paramBufferedReader, char[] paramArrayOfChar1, StringBuilder paramStringBuilder, char[] paramArrayOfChar2)
  {
    AppMethodBeat.i(61531);
    paramStringBuilder.setLength(0);
    paramBufferedReader.mark(paramArrayOfChar1.length);
    int i = 0;
    int j = 0;
    for (;;)
    {
      int n = paramBufferedReader.read(paramArrayOfChar1);
      if (n == -1) {
        break;
      }
      int k = 0;
      if (k < n)
      {
        char c = paramArrayOfChar1[k];
        int m;
        if (Character.isISOControl(c))
        {
          if (paramArrayOfChar2 != null)
          {
            m = 0;
            if (m < paramArrayOfChar2.length) {
              if (paramArrayOfChar2[m] != c) {}
            }
          }
          for (m = 1;; m = 0)
          {
            if (m != 0) {
              break label124;
            }
            paramBufferedReader = new FastParser.ParseException("Unexpected control character while reading string");
            AppMethodBeat.o(61531);
            throw paramBufferedReader;
            m += 1;
            break;
          }
        }
        label124:
        if ((c == '"') && (j == 0))
        {
          paramStringBuilder.append(paramArrayOfChar1, 0, k);
          paramBufferedReader.reset();
          paramBufferedReader.skip(k + 1);
          if (i != 0)
          {
            paramBufferedReader = JsonUtils.unescapeString(paramStringBuilder.toString());
            AppMethodBeat.o(61531);
            return paramBufferedReader;
          }
          paramBufferedReader = paramStringBuilder.toString();
          AppMethodBeat.o(61531);
          return paramBufferedReader;
        }
        if (c == '\\') {
          if (j == 0)
          {
            i = 1;
            label208:
            m = 1;
            j = i;
            i = m;
          }
        }
        for (;;)
        {
          k += 1;
          break;
          i = 0;
          break label208;
          j = 0;
        }
      }
      paramStringBuilder.append(paramArrayOfChar1, 0, n);
      paramBufferedReader.mark(paramArrayOfChar1.length);
    }
    paramBufferedReader = new FastParser.ParseException("Unexpected EOF while parsing string");
    AppMethodBeat.o(61531);
    throw paramBufferedReader;
  }
  
  private final void zzb(BufferedReader paramBufferedReader, char[] paramArrayOfChar)
  {
    AppMethodBeat.i(61542);
    int i = 0;
    while (i < paramArrayOfChar.length)
    {
      int k = paramBufferedReader.read(this.zzwr, 0, paramArrayOfChar.length - i);
      if (k == -1)
      {
        paramBufferedReader = new FastParser.ParseException("Unexpected EOF");
        AppMethodBeat.o(61542);
        throw paramBufferedReader;
      }
      int j = 0;
      while (j < k)
      {
        if (paramArrayOfChar[(j + i)] != this.zzwr[j])
        {
          paramBufferedReader = new FastParser.ParseException("Unexpected character");
          AppMethodBeat.o(61542);
          throw paramBufferedReader;
        }
        j += 1;
      }
      i += k;
    }
    AppMethodBeat.o(61542);
  }
  
  private final String zzc(BufferedReader paramBufferedReader)
  {
    AppMethodBeat.i(61528);
    paramBufferedReader = zza(paramBufferedReader, this.zzwr, this.zzwt, null);
    AppMethodBeat.o(61528);
    return paramBufferedReader;
  }
  
  private final int zzd(BufferedReader paramBufferedReader)
  {
    int j = 0;
    AppMethodBeat.i(61532);
    int i1 = zza(paramBufferedReader, this.zzws);
    if (i1 == 0)
    {
      AppMethodBeat.o(61532);
      return 0;
    }
    paramBufferedReader = this.zzws;
    int k;
    int i;
    int m;
    int n;
    if (i1 > 0)
    {
      if (paramBufferedReader[0] == '-')
      {
        k = -2147483648;
        i = 1;
        m = 1;
      }
      while (i < i1)
      {
        j = i + 1;
        i = Character.digit(paramBufferedReader[i], 10);
        if (i < 0)
        {
          paramBufferedReader = new FastParser.ParseException("Unexpected non-digit character");
          AppMethodBeat.o(61532);
          throw paramBufferedReader;
          k = -2147483647;
          i = 0;
          m = 0;
        }
        else
        {
          n = -i;
          i = j;
          j = n;
        }
      }
    }
    for (;;)
    {
      if (i < i1)
      {
        n = Character.digit(paramBufferedReader[i], 10);
        if (n < 0)
        {
          paramBufferedReader = new FastParser.ParseException("Unexpected non-digit character");
          AppMethodBeat.o(61532);
          throw paramBufferedReader;
        }
        if (j < -214748364)
        {
          paramBufferedReader = new FastParser.ParseException("Number too large");
          AppMethodBeat.o(61532);
          throw paramBufferedReader;
        }
        j *= 10;
        if (j < k + n)
        {
          paramBufferedReader = new FastParser.ParseException("Number too large");
          AppMethodBeat.o(61532);
          throw paramBufferedReader;
        }
        j -= n;
        i += 1;
        continue;
        paramBufferedReader = new FastParser.ParseException("No number to parse");
        AppMethodBeat.o(61532);
        throw paramBufferedReader;
      }
      else
      {
        if (m != 0)
        {
          if (i > 1)
          {
            AppMethodBeat.o(61532);
            return j;
          }
          paramBufferedReader = new FastParser.ParseException("No digits to parse");
          AppMethodBeat.o(61532);
          throw paramBufferedReader;
        }
        i = -j;
        AppMethodBeat.o(61532);
        return i;
      }
    }
  }
  
  private final long zze(BufferedReader paramBufferedReader)
  {
    long l1 = 0L;
    AppMethodBeat.i(61533);
    int m = zza(paramBufferedReader, this.zzws);
    if (m == 0)
    {
      AppMethodBeat.o(61533);
      return 0L;
    }
    paramBufferedReader = this.zzws;
    long l2;
    int i;
    int j;
    int k;
    if (m > 0)
    {
      if (paramBufferedReader[0] == '-')
      {
        l2 = -9223372036854775808L;
        i = 1;
        j = 1;
      }
      while (i < m)
      {
        k = i + 1;
        i = Character.digit(paramBufferedReader[i], 10);
        if (i < 0)
        {
          paramBufferedReader = new FastParser.ParseException("Unexpected non-digit character");
          AppMethodBeat.o(61533);
          throw paramBufferedReader;
          l2 = -9223372036854775807L;
          i = 0;
          j = 0;
        }
        else
        {
          l1 = -i;
          i = k;
        }
      }
    }
    for (;;)
    {
      if (i < m)
      {
        k = Character.digit(paramBufferedReader[i], 10);
        if (k < 0)
        {
          paramBufferedReader = new FastParser.ParseException("Unexpected non-digit character");
          AppMethodBeat.o(61533);
          throw paramBufferedReader;
        }
        if (l1 < -922337203685477580L)
        {
          paramBufferedReader = new FastParser.ParseException("Number too large");
          AppMethodBeat.o(61533);
          throw paramBufferedReader;
        }
        l1 *= 10L;
        if (l1 < k + l2)
        {
          paramBufferedReader = new FastParser.ParseException("Number too large");
          AppMethodBeat.o(61533);
          throw paramBufferedReader;
        }
        l1 -= k;
        i += 1;
        continue;
        paramBufferedReader = new FastParser.ParseException("No number to parse");
        AppMethodBeat.o(61533);
        throw paramBufferedReader;
      }
      else
      {
        if (j != 0)
        {
          if (i > 1)
          {
            AppMethodBeat.o(61533);
            return l1;
          }
          paramBufferedReader = new FastParser.ParseException("No digits to parse");
          AppMethodBeat.o(61533);
          throw paramBufferedReader;
        }
        l1 = -l1;
        AppMethodBeat.o(61533);
        return l1;
      }
    }
  }
  
  private final BigInteger zzf(BufferedReader paramBufferedReader)
  {
    AppMethodBeat.i(61534);
    int i = zza(paramBufferedReader, this.zzws);
    if (i == 0)
    {
      AppMethodBeat.o(61534);
      return null;
    }
    paramBufferedReader = new BigInteger(new String(this.zzws, 0, i));
    AppMethodBeat.o(61534);
    return paramBufferedReader;
  }
  
  private final float zzg(BufferedReader paramBufferedReader)
  {
    AppMethodBeat.i(61536);
    int i = zza(paramBufferedReader, this.zzws);
    if (i == 0)
    {
      AppMethodBeat.o(61536);
      return 0.0F;
    }
    float f = Float.parseFloat(new String(this.zzws, 0, i));
    AppMethodBeat.o(61536);
    return f;
  }
  
  private final double zzh(BufferedReader paramBufferedReader)
  {
    AppMethodBeat.i(61537);
    int i = zza(paramBufferedReader, this.zzws);
    if (i == 0)
    {
      AppMethodBeat.o(61537);
      return 0.0D;
    }
    double d = Double.parseDouble(new String(this.zzws, 0, i));
    AppMethodBeat.o(61537);
    return d;
  }
  
  private final BigDecimal zzi(BufferedReader paramBufferedReader)
  {
    AppMethodBeat.i(61538);
    int i = zza(paramBufferedReader, this.zzws);
    if (i == 0)
    {
      AppMethodBeat.o(61538);
      return null;
    }
    paramBufferedReader = new BigDecimal(new String(this.zzws, 0, i));
    AppMethodBeat.o(61538);
    return paramBufferedReader;
  }
  
  private final char zzj(BufferedReader paramBufferedReader)
  {
    AppMethodBeat.i(61540);
    if (paramBufferedReader.read(this.zzwq) == -1)
    {
      AppMethodBeat.o(61540);
      return '\000';
    }
    while (Character.isWhitespace(this.zzwq[0])) {
      if (paramBufferedReader.read(this.zzwq) == -1)
      {
        AppMethodBeat.o(61540);
        return '\000';
      }
    }
    char c = this.zzwq[0];
    AppMethodBeat.o(61540);
    return c;
  }
  
  private final void zzk(int paramInt)
  {
    AppMethodBeat.i(61543);
    FastParser.ParseException localParseException;
    if (this.zzxb.isEmpty())
    {
      localParseException = new FastParser.ParseException(46 + "Expected state " + paramInt + " but had empty stack");
      AppMethodBeat.o(61543);
      throw localParseException;
    }
    int i = ((Integer)this.zzxb.pop()).intValue();
    if (i != paramInt)
    {
      localParseException = new FastParser.ParseException(46 + "Expected state " + paramInt + " but had " + i);
      AppMethodBeat.o(61543);
      throw localParseException;
    }
    AppMethodBeat.o(61543);
  }
  
  public void parse(InputStream paramInputStream, T paramT)
  {
    AppMethodBeat.i(61523);
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream), 1024);
    try
    {
      this.zzxb.push(Integer.valueOf(0));
      c = zzj(paramInputStream);
      switch (c)
      {
      }
    }
    catch (IOException paramT)
    {
      char c;
      paramT = new FastParser.ParseException(paramT);
      AppMethodBeat.o(61523);
      throw paramT;
    }
    finally
    {
      for (;;)
      {
        try
        {
          paramInputStream.close();
          AppMethodBeat.o(61523);
          throw paramT;
          this.zzxb.push(Integer.valueOf(1));
          zza(paramInputStream, paramT);
          zzk(0);
          try
          {
            paramInputStream.close();
            AppMethodBeat.o(61523);
            return;
          }
          catch (IOException paramInputStream)
          {
            Object localObject;
            ArrayList localArrayList;
            AppMethodBeat.o(61523);
            return;
          }
          this.zzxb.push(Integer.valueOf(5));
          localObject = paramT.getFieldMappings();
          if (((Map)localObject).size() != 1)
          {
            paramT = new FastParser.ParseException("Object array response class must have a single Field");
            AppMethodBeat.o(61523);
            throw paramT;
          }
          localObject = (FastJsonResponse.Field)((Map.Entry)((Map)localObject).entrySet().iterator().next()).getValue();
          localArrayList = zza(paramInputStream, (FastJsonResponse.Field)localObject);
          paramT.addConcreteTypeArrayInternal((FastJsonResponse.Field)localObject, ((FastJsonResponse.Field)localObject).getOutputFieldName(), localArrayList);
          continue;
          paramT = new FastParser.ParseException("No data to parse");
          AppMethodBeat.o(61523);
          throw paramT;
        }
        catch (IOException paramInputStream) {}
      }
    }
    paramT = new FastParser.ParseException(19 + "Unexpected token: " + c);
    AppMethodBeat.o(61523);
    throw paramT;
  }
  
  public void parse(String paramString, T paramT)
  {
    AppMethodBeat.i(61524);
    paramString = new ByteArrayInputStream(paramString.getBytes());
    try
    {
      parse(paramString, paramT);
      try
      {
        paramString.close();
        AppMethodBeat.o(61524);
        return;
      }
      catch (IOException paramString)
      {
        AppMethodBeat.o(61524);
        return;
      }
      try
      {
        paramString.close();
        AppMethodBeat.o(61524);
        throw paramT;
      }
      catch (IOException paramString)
      {
        break label48;
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.server.response.FastParser
 * JD-Core Version:    0.7.0.1
 */