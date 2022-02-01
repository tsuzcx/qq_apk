package com.qq.a.a;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class b
  extends JceStruct
{
  protected HashMap<String, HashMap<String, byte[]>> cge;
  private HashMap<String, Object> cgf;
  private HashMap<String, Object> cgg;
  protected String cgh;
  JceInputStream cgj;
  
  static
  {
    AppMethodBeat.i(187108);
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(187108);
      return;
    }
  }
  
  public b()
  {
    AppMethodBeat.i(187102);
    this.cge = new HashMap();
    this.cgf = new HashMap(128);
    this.cgg = new HashMap(128);
    this.cgh = "GBK";
    this.cgj = new JceInputStream();
    AppMethodBeat.o(187102);
  }
  
  private void c(ArrayList<String> paramArrayList, Object paramObject)
  {
    AppMethodBeat.i(187100);
    for (;;)
    {
      if (paramObject.getClass().isArray())
      {
        if (!paramObject.getClass().getComponentType().toString().equals("byte"))
        {
          paramArrayList = new IllegalArgumentException("only byte[] is supported");
          AppMethodBeat.o(187100);
          throw paramArrayList;
        }
        if (Array.getLength(paramObject) > 0)
        {
          paramArrayList.add("java.util.List");
          paramObject = Array.get(paramObject, 0);
        }
        else
        {
          paramArrayList.add("Array");
          paramArrayList.add("?");
          AppMethodBeat.o(187100);
        }
      }
      else
      {
        if ((paramObject instanceof Array))
        {
          paramArrayList = new IllegalArgumentException("can not support Array, please use List");
          AppMethodBeat.o(187100);
          throw paramArrayList;
        }
        if ((paramObject instanceof List))
        {
          paramArrayList.add("java.util.List");
          paramObject = (List)paramObject;
          if (paramObject.size() > 0)
          {
            paramObject = paramObject.get(0);
          }
          else
          {
            paramArrayList.add("?");
            AppMethodBeat.o(187100);
          }
        }
        else
        {
          if (!(paramObject instanceof Map)) {
            break label257;
          }
          paramArrayList.add("java.util.Map");
          paramObject = (Map)paramObject;
          if (paramObject.size() <= 0) {
            break;
          }
          Object localObject = paramObject.keySet().iterator().next();
          paramObject = paramObject.get(localObject);
          paramArrayList.add(localObject.getClass().getName());
        }
      }
    }
    paramArrayList.add("?");
    paramArrayList.add("?");
    AppMethodBeat.o(187100);
    return;
    label257:
    paramArrayList.add(paramObject.getClass().getName());
    AppMethodBeat.o(187100);
  }
  
  public byte[] IJ()
  {
    AppMethodBeat.i(187101);
    Object localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.cgh);
    ((JceOutputStream)localObject).write(this.cge, 0);
    localObject = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    AppMethodBeat.o(187101);
    return localObject;
  }
  
  public Object clone()
  {
    AppMethodBeat.i(187104);
    localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      localObject1 = new AssertionError();
      AppMethodBeat.o(187104);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(187104);
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(187107);
    new JceDisplayer(paramStringBuilder, paramInt).display(this.cge, "_data");
    AppMethodBeat.o(187107);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(187103);
    boolean bool = JceUtil.equals(Integer.valueOf(1), ((b)paramObject).cge);
    AppMethodBeat.o(187103);
    return bool;
  }
  
  public <T> void put(String paramString, T paramT)
  {
    AppMethodBeat.i(187099);
    if (paramString == null)
    {
      paramString = new IllegalArgumentException("put key can not is null");
      AppMethodBeat.o(187099);
      throw paramString;
    }
    if (paramT == null)
    {
      paramString = new IllegalArgumentException("put value can not is null");
      AppMethodBeat.o(187099);
      throw paramString;
    }
    if ((paramT instanceof Set))
    {
      paramString = new IllegalArgumentException("can not support Set");
      AppMethodBeat.o(187099);
      throw paramString;
    }
    Object localObject = new JceOutputStream();
    ((JceOutputStream)localObject).setServerEncoding(this.cgh);
    ((JceOutputStream)localObject).write(paramT, 0);
    localObject = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    HashMap localHashMap = new HashMap(1);
    ArrayList localArrayList = new ArrayList(1);
    c(localArrayList, paramT);
    localHashMap.put(a.d(localArrayList), localObject);
    this.cgg.remove(paramString);
    this.cge.put(paramString, localHashMap);
    AppMethodBeat.o(187099);
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(187106);
    this.cge.clear();
    HashMap localHashMap = new HashMap();
    byte[] arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = Byte.valueOf(0).byteValue();
    localHashMap.put("", arrayOfByte);
    this.cge.put("", localHashMap);
    this.cge = ((HashMap)paramJceInputStream.read(this.cge, 0, true));
    AppMethodBeat.o(187106);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(187105);
    paramJceOutputStream.write(this.cge, 0);
    AppMethodBeat.o(187105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.qq.a.a.b
 * JD-Core Version:    0.7.0.1
 */