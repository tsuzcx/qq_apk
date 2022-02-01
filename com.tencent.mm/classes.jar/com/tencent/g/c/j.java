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
  private static byte[] ZRE = { 68, 70, 71, 35, 36, 37, 94, 35, 37, 36, 82, 71, 72, 82, 40, 38, 42, 77, 60, 62, 60 };
  private static byte[] ZRF = { 77, 12, 61, -119, 116, -43, 122, -45, 103, -63, -105, 16, 70, 121, -88, 42 };
  private static byte[] ZRG = { -27, -63, 58, 27, 82, 11, -15, -54, -59, -75, 1, 61, 125, 119, 90, -8 };
  
  public static Map<String, String> a(a parama)
  {
    AppMethodBeat.i(207442);
    Object localObject1 = new ArrayList();
    Object localObject2 = itB();
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
        ((b)localObject2).readFrom(new JceInputStream(parama.dt(parama.s(parama.readFile(str1), ZRE))));
        int i = ((b)localObject2).ZRH.size();
        if (i != 0)
        {
          parama = ((b)localObject2).ZRH;
          AppMethodBeat.o(207442);
          return parama;
        }
      }
      catch (Throwable localThrowable) {}
    }
  }
  
  private static String b(a parama)
  {
    AppMethodBeat.i(207445);
    try
    {
      parama = new String(parama.s(ZRF, ZRE), "UTF-8");
      AppMethodBeat.o(207445);
      return parama;
    }
    catch (Throwable parama)
    {
      for (;;)
      {
        parama = "";
      }
    }
  }
  
  private static String c(a parama)
  {
    AppMethodBeat.i(207446);
    try
    {
      parama = new String(parama.s(ZRG, ZRE), "UTF-8");
      AppMethodBeat.o(207446);
      return parama;
    }
    catch (Throwable parama)
    {
      for (;;)
      {
        parama = "";
      }
    }
  }
  
  private static String itA()
  {
    AppMethodBeat.i(207443);
    try
    {
      int i = Process.myUid() / 100000;
      Object localObject2 = Class.forName("android.os.Environment$UserEnvironment");
      Object localObject1 = ((Class)localObject2).getConstructor(new Class[] { Integer.TYPE }).newInstance(new Object[] { Integer.valueOf(i) });
      localObject2 = ((Class)localObject2).getMethod("getExternalStorageDirectory", new Class[0]);
      ((Method)localObject2).setAccessible(true);
      localObject1 = ((File)((Method)localObject2).invoke(localObject1, new Object[0])).getAbsolutePath();
      AppMethodBeat.o(207443);
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(207443);
    }
    return "";
  }
  
  private static String itB()
  {
    AppMethodBeat.i(207444);
    String str3 = itA();
    String str1 = str3;
    if (TextUtils.isEmpty(str3)) {}
    try
    {
      str1 = Environment.getExternalStorageDirectory().getAbsolutePath();
      AppMethodBeat.o(207444);
      return str1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str2 = str3;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract byte[] dt(byte[] paramArrayOfByte);
    
    public abstract byte[] readFile(String paramString);
    
    public abstract byte[] s(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  }
  
  static final class b
    extends JceStruct
  {
    static Map<String, String> ZRI;
    public Map<String, String> ZRH;
    
    public b()
    {
      AppMethodBeat.i(208769);
      this.ZRH = null;
      ZRI = new HashMap();
      ZRI.put("", "");
      AppMethodBeat.o(208769);
    }
    
    public final void readFrom(JceInputStream paramJceInputStream)
    {
      AppMethodBeat.i(208771);
      this.ZRH = ((Map)paramJceInputStream.read(ZRI, 0, true));
      AppMethodBeat.o(208771);
    }
    
    public final void writeTo(JceOutputStream paramJceOutputStream)
    {
      AppMethodBeat.i(208770);
      paramJceOutputStream.write(this.ZRH, 0);
      AppMethodBeat.o(208770);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.g.c.j
 * JD-Core Version:    0.7.0.1
 */