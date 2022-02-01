package com.tencent.g.c;

import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class j
{
  private static byte[] ahWb = { 68, 70, 71, 35, 36, 37, 94, 35, 37, 36, 82, 71, 72, 82, 40, 38, 42, 77, 60, 62, 60 };
  private static byte[] ahWc = { 77, 12, 61, -119, 116, -43, 122, -45, 103, -63, -105, 16, 70, 121, -88, 42 };
  private static byte[] ahWd = { -27, -63, 58, 27, 82, 11, -15, -54, -59, -75, 1, 61, 125, 119, 90, -8 };
  
  public static Map<String, String> a(a parama)
  {
    AppMethodBeat.i(212041);
    Object localObject1 = new ArrayList();
    Object localObject2 = kcW();
    String str1 = b(parama);
    String str2 = c(parama);
    ((List)localObject1).add((String)localObject2 + str1 + str2);
    ((List)localObject1).add((String)localObject2 + str2);
    localObject2 = new b();
    localObject1 = ((List)localObject1).iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext()) {
        str1 = (String)((Iterator)localObject1).next();
      }
      try
      {
        ((b)localObject2).readFrom(new JceInputStream(parama.dv(parama.t(parama.readFile(str1), ahWb))));
        int i = ((b)localObject2).ahWe.size();
        if (i != 0)
        {
          parama = ((b)localObject2).ahWe;
          AppMethodBeat.o(212041);
          return parama;
        }
      }
      finally {}
    }
  }
  
  private static String b(a parama)
  {
    AppMethodBeat.i(212058);
    try
    {
      parama = new String(parama.t(ahWc, ahWb), "UTF-8");
      AppMethodBeat.o(212058);
      return parama;
    }
    finally
    {
      for (;;)
      {
        parama = "";
      }
    }
  }
  
  private static String c(a parama)
  {
    AppMethodBeat.i(212062);
    try
    {
      parama = new String(parama.t(ahWd, ahWb), "UTF-8");
      AppMethodBeat.o(212062);
      return parama;
    }
    finally
    {
      for (;;)
      {
        parama = "";
      }
    }
  }
  
  private static String kcV()
  {
    AppMethodBeat.i(212047);
    try
    {
      int i = Process.myUid() / 100000;
      Object localObject3 = Class.forName("android.os.Environment$UserEnvironment");
      Object localObject1 = ((Class)localObject3).getConstructor(new Class[] { Integer.TYPE }).newInstance(new Object[] { Integer.valueOf(i) });
      localObject3 = ((Class)localObject3).getMethod("getExternalStorageDirectory", new Class[0]);
      ((Method)localObject3).setAccessible(true);
      localObject1 = ((File)((Method)localObject3).invoke(localObject1, new Object[0])).getAbsolutePath();
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(212047);
    }
    return "";
  }
  
  private static String kcW()
  {
    AppMethodBeat.i(212051);
    String str3 = kcV();
    String str1 = str3;
    if (TextUtils.isEmpty(str3)) {}
    try
    {
      str1 = Environment.getExternalStorageDirectory().getAbsolutePath();
      AppMethodBeat.o(212051);
      return str1;
    }
    finally
    {
      for (;;)
      {
        String str2 = str3;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract byte[] dv(byte[] paramArrayOfByte);
    
    public abstract byte[] readFile(String paramString);
    
    public abstract byte[] t(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  }
  
  static final class b
    extends JceStruct
  {
    static Map<String, String> ahWf;
    public Map<String, String> ahWe;
    
    public b()
    {
      AppMethodBeat.i(212044);
      this.ahWe = null;
      ahWf = new HashMap();
      ahWf.put("", "");
      AppMethodBeat.o(212044);
    }
    
    public final void readFrom(JceInputStream paramJceInputStream)
    {
      AppMethodBeat.i(212060);
      this.ahWe = ((Map)paramJceInputStream.read(ahWf, 0, true));
      AppMethodBeat.o(212060);
    }
    
    public final void writeTo(JceOutputStream paramJceOutputStream)
    {
      AppMethodBeat.i(212053);
      paramJceOutputStream.write(this.ahWe, 0);
      AppMethodBeat.o(212053);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.g.c.j
 * JD-Core Version:    0.7.0.1
 */