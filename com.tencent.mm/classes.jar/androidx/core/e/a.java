package androidx.core.e;

import android.text.SpannableStringBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public final class a
{
  static final d brT;
  private static final String brU;
  private static final String brV;
  static final a brW;
  static final a brX;
  private final boolean brY;
  private final d brZ;
  private final int cN;
  
  static
  {
    AppMethodBeat.i(195491);
    brT = e.bsr;
    brU = Character.toString('‎');
    brV = Character.toString('‏');
    brW = new a(false, 2, brT);
    brX = new a(true, 2, brT);
    AppMethodBeat.o(195491);
  }
  
  private a(boolean paramBoolean, int paramInt, d paramd)
  {
    this.brY = paramBoolean;
    this.cN = paramInt;
    this.brZ = paramd;
  }
  
  public static a DT()
  {
    AppMethodBeat.i(195451);
    Object localObject = new a();
    if ((((a)localObject).cN == 2) && (((a)localObject).bsa == brT))
    {
      if (((a)localObject).brY)
      {
        localObject = brX;
        AppMethodBeat.o(195451);
        return localObject;
      }
      localObject = brW;
      AppMethodBeat.o(195451);
      return localObject;
    }
    localObject = new a(((a)localObject).brY, ((a)localObject).cN, ((a)localObject).bsa);
    AppMethodBeat.o(195451);
    return localObject;
  }
  
  static boolean a(Locale paramLocale)
  {
    AppMethodBeat.i(195466);
    if (f.d(paramLocale) == 1)
    {
      AppMethodBeat.o(195466);
      return true;
    }
    AppMethodBeat.o(195466);
    return false;
  }
  
  private static int s(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(195475);
    int i = new b(paramCharSequence).DV();
    AppMethodBeat.o(195475);
    return i;
  }
  
  private static int t(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(195483);
    int i = new b(paramCharSequence).DU();
    AppMethodBeat.o(195483);
    return i;
  }
  
  public final CharSequence r(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(195503);
    Object localObject = this.brZ;
    if (paramCharSequence == null)
    {
      AppMethodBeat.o(195503);
      return null;
    }
    boolean bool1 = ((d)localObject).a(paramCharSequence, paramCharSequence.length());
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int k;
    label72:
    boolean bool2;
    if ((this.cN & 0x2) != 0)
    {
      k = 1;
      if (k != 0)
      {
        if (!bool1) {
          break label232;
        }
        localObject = e.bsq;
        bool2 = ((d)localObject).a(paramCharSequence, paramCharSequence.length());
        if ((this.brY) || ((!bool2) && (t(paramCharSequence) != 1))) {
          break label240;
        }
        localObject = brU;
        label113:
        localSpannableStringBuilder.append((CharSequence)localObject);
      }
      if (bool1 == this.brY) {
        break label282;
      }
      if (!bool1) {
        break label275;
      }
      int i = 8235;
      label139:
      localSpannableStringBuilder.append(i);
      localSpannableStringBuilder.append(paramCharSequence);
      localSpannableStringBuilder.append('‬');
      label162:
      if (!bool1) {
        break label292;
      }
      localObject = e.bsq;
      label172:
      bool1 = ((d)localObject).a(paramCharSequence, paramCharSequence.length());
      if ((this.brY) || ((!bool1) && (s(paramCharSequence) != 1))) {
        break label300;
      }
      paramCharSequence = brU;
    }
    for (;;)
    {
      localSpannableStringBuilder.append(paramCharSequence);
      AppMethodBeat.o(195503);
      return localSpannableStringBuilder;
      k = 0;
      break;
      label232:
      localObject = e.bsp;
      break label72;
      label240:
      if ((this.brY) && ((!bool2) || (t(paramCharSequence) == -1)))
      {
        localObject = brV;
        break label113;
      }
      localObject = "";
      break label113;
      label275:
      int j = 8234;
      break label139;
      label282:
      localSpannableStringBuilder.append(paramCharSequence);
      break label162;
      label292:
      localObject = e.bsp;
      break label172;
      label300:
      if ((this.brY) && ((!bool1) || (s(paramCharSequence) == -1))) {
        paramCharSequence = brV;
      } else {
        paramCharSequence = "";
      }
    }
  }
  
  public static final class a
  {
    boolean brY;
    d bsa;
    int cN;
    
    public a()
    {
      AppMethodBeat.i(195463);
      this.brY = a.a(Locale.getDefault());
      this.bsa = a.brT;
      this.cN = 2;
      AppMethodBeat.o(195463);
    }
  }
  
  static final class b
  {
    private static final byte[] bsb;
    private final CharSequence bba;
    private final boolean bsc;
    private int bsd;
    private char bse;
    private final int length;
    
    static
    {
      AppMethodBeat.i(195564);
      bsb = new byte[1792];
      int i = 0;
      while (i < 1792)
      {
        bsb[i] = Character.getDirectionality(i);
        i += 1;
      }
      AppMethodBeat.o(195564);
    }
    
    b(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(195472);
      this.bba = paramCharSequence;
      this.bsc = false;
      this.length = paramCharSequence.length();
      AppMethodBeat.o(195472);
    }
    
    private byte DW()
    {
      AppMethodBeat.i(195494);
      this.bse = this.bba.charAt(this.bsd);
      if (Character.isHighSurrogate(this.bse))
      {
        int i = Character.codePointAt(this.bba, this.bsd);
        this.bsd += Character.charCount(i);
        b1 = Character.getDirectionality(i);
        AppMethodBeat.o(195494);
        return b1;
      }
      this.bsd += 1;
      byte b2 = b(this.bse);
      byte b1 = b2;
      if (this.bsc)
      {
        if (this.bse != '<') {
          break label117;
        }
        b1 = DY();
      }
      for (;;)
      {
        AppMethodBeat.o(195494);
        return b1;
        label117:
        b1 = b2;
        if (this.bse == '&') {
          b1 = Ea();
        }
      }
    }
    
    private byte DX()
    {
      AppMethodBeat.i(195509);
      this.bse = this.bba.charAt(this.bsd - 1);
      if (Character.isLowSurrogate(this.bse))
      {
        int i = Character.codePointBefore(this.bba, this.bsd);
        this.bsd -= Character.charCount(i);
        b1 = Character.getDirectionality(i);
        AppMethodBeat.o(195509);
        return b1;
      }
      this.bsd -= 1;
      byte b2 = b(this.bse);
      byte b1 = b2;
      if (this.bsc)
      {
        if (this.bse != '>') {
          break label119;
        }
        b1 = DZ();
      }
      for (;;)
      {
        AppMethodBeat.o(195509);
        return b1;
        label119:
        b1 = b2;
        if (this.bse == ';') {
          b1 = Eb();
        }
      }
    }
    
    private byte DY()
    {
      AppMethodBeat.i(195520);
      int j = this.bsd;
      for (;;)
      {
        if (this.bsd >= this.length) {
          break label145;
        }
        CharSequence localCharSequence = this.bba;
        int k = this.bsd;
        this.bsd = (k + 1);
        this.bse = localCharSequence.charAt(k);
        if (this.bse == '>')
        {
          AppMethodBeat.o(195520);
          return 12;
        }
        if ((this.bse == '"') || (this.bse == '\''))
        {
          k = this.bse;
          if (this.bsd < this.length)
          {
            localCharSequence = this.bba;
            int m = this.bsd;
            this.bsd = (m + 1);
            int i = localCharSequence.charAt(m);
            this.bse = i;
            if (i != k) {
              break;
            }
          }
        }
      }
      label145:
      this.bsd = j;
      this.bse = '<';
      AppMethodBeat.o(195520);
      return 13;
    }
    
    private byte DZ()
    {
      AppMethodBeat.i(195535);
      int j = this.bsd;
      for (;;)
      {
        if (this.bsd <= 0) {
          break label146;
        }
        CharSequence localCharSequence = this.bba;
        int k = this.bsd - 1;
        this.bsd = k;
        this.bse = localCharSequence.charAt(k);
        if (this.bse == '<')
        {
          AppMethodBeat.o(195535);
          return 12;
        }
        if (this.bse == '>') {
          break label146;
        }
        if ((this.bse == '"') || (this.bse == '\''))
        {
          k = this.bse;
          if (this.bsd > 0)
          {
            localCharSequence = this.bba;
            int m = this.bsd - 1;
            this.bsd = m;
            int i = localCharSequence.charAt(m);
            this.bse = i;
            if (i != k) {
              break;
            }
          }
        }
      }
      label146:
      this.bsd = j;
      this.bse = '>';
      AppMethodBeat.o(195535);
      return 13;
    }
    
    private byte Ea()
    {
      AppMethodBeat.i(195545);
      char c;
      do
      {
        if (this.bsd >= this.length) {
          break;
        }
        CharSequence localCharSequence = this.bba;
        int i = this.bsd;
        this.bsd = (i + 1);
        c = localCharSequence.charAt(i);
        this.bse = c;
      } while (c != ';');
      AppMethodBeat.o(195545);
      return 12;
    }
    
    private byte Eb()
    {
      AppMethodBeat.i(195557);
      int i = this.bsd;
      do
      {
        if (this.bsd <= 0) {
          break;
        }
        CharSequence localCharSequence = this.bba;
        int j = this.bsd - 1;
        this.bsd = j;
        this.bse = localCharSequence.charAt(j);
        if (this.bse == '&')
        {
          AppMethodBeat.o(195557);
          return 12;
        }
      } while (this.bse != ';');
      this.bsd = i;
      this.bse = ';';
      AppMethodBeat.o(195557);
      return 13;
    }
    
    private static byte b(char paramChar)
    {
      AppMethodBeat.i(195481);
      if (paramChar < '܀')
      {
        b = bsb[paramChar];
        AppMethodBeat.o(195481);
        return b;
      }
      byte b = Character.getDirectionality(paramChar);
      AppMethodBeat.o(195481);
      return b;
    }
    
    final int DU()
    {
      AppMethodBeat.i(195578);
      this.bsd = 0;
      int j = 0;
      int k = 0;
      int i = 0;
      while ((this.bsd < this.length) && (j == 0)) {
        switch (DW())
        {
        case 9: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        default: 
          j = i;
          break;
        case 14: 
        case 15: 
          i += 1;
          k = -1;
          break;
        case 16: 
        case 17: 
          i += 1;
          k = 1;
          break;
        case 18: 
          i -= 1;
          k = 0;
          break;
        case 0: 
          if (i == 0)
          {
            AppMethodBeat.o(195578);
            return -1;
          }
          j = i;
          break;
        case 1: 
        case 2: 
          if (i == 0)
          {
            AppMethodBeat.o(195578);
            return 1;
          }
          j = i;
        }
      }
      if (j == 0)
      {
        AppMethodBeat.o(195578);
        return 0;
      }
      if (k != 0)
      {
        AppMethodBeat.o(195578);
        return k;
      }
      while (this.bsd > 0) {
        switch (DX())
        {
        default: 
          break;
        case 14: 
        case 15: 
          if (j == i)
          {
            AppMethodBeat.o(195578);
            return -1;
          }
          i -= 1;
          break;
        case 16: 
        case 17: 
          if (j == i)
          {
            AppMethodBeat.o(195578);
            return 1;
          }
          i -= 1;
          break;
        case 18: 
          i += 1;
        }
      }
      AppMethodBeat.o(195578);
      return 0;
    }
    
    final int DV()
    {
      AppMethodBeat.i(195595);
      this.bsd = this.length;
      int j = 0;
      int i = 0;
      while (this.bsd > 0) {
        switch (DX())
        {
        case 9: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        default: 
          if (j == 0) {
            j = i;
          }
          break;
        case 0: 
          if (i == 0)
          {
            AppMethodBeat.o(195595);
            return -1;
          }
          if (j == 0) {
            j = i;
          }
          break;
        case 14: 
        case 15: 
          if (j == i)
          {
            AppMethodBeat.o(195595);
            return -1;
          }
          i -= 1;
          break;
        case 1: 
        case 2: 
          if (i == 0)
          {
            AppMethodBeat.o(195595);
            return 1;
          }
          if (j == 0) {
            j = i;
          }
          break;
        case 16: 
        case 17: 
          if (j == i)
          {
            AppMethodBeat.o(195595);
            return 1;
          }
          i -= 1;
          break;
        case 18: 
          i += 1;
        }
      }
      AppMethodBeat.o(195595);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.e.a
 * JD-Core Version:    0.7.0.1
 */