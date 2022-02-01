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
  protected HashMap<String, HashMap<String, byte[]>> dYF;
  private HashMap<String, Object> dYG;
  private HashMap<String, Object> dYH;
  protected String dYI;
  JceInputStream dYJ;
  
  static
  {
    AppMethodBeat.i(208296);
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(208296);
      return;
    }
  }
  
  public b()
  {
    AppMethodBeat.i(208291);
    this.dYF = new HashMap();
    this.dYG = new HashMap(128);
    this.dYH = new HashMap(128);
    this.dYI = "GBK";
    this.dYJ = new JceInputStream();
    AppMethodBeat.o(208291);
  }
  
  private void e(ArrayList<String> paramArrayList, Object paramObject)
  {
    AppMethodBeat.i(208285);
    for (;;)
    {
      if (paramObject.getClass().isArray())
      {
        if (!paramObject.getClass().getComponentType().toString().equals("byte"))
        {
          paramArrayList = new IllegalArgumentException("only byte[] is supported");
          AppMethodBeat.o(208285);
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
          AppMethodBeat.o(208285);
        }
      }
      else
      {
        if ((paramObject instanceof Array))
        {
          paramArrayList = new IllegalArgumentException("can not support Array, please use List");
          AppMethodBeat.o(208285);
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
            AppMethodBeat.o(208285);
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
    AppMethodBeat.o(208285);
    return;
    label257:
    paramArrayList.add(paramObject.getClass().getName());
    AppMethodBeat.o(208285);
  }
  
  public byte[] akn()
  {
    AppMethodBeat.i(208302);
    Object localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.dYI);
    ((JceOutputStream)localObject).write(this.dYF, 0);
    localObject = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    AppMethodBeat.o(208302);
    return localObject;
  }
  
  public Object clone()
  {
    AppMethodBeat.i(208309);
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
      AppMethodBeat.o(208309);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(208309);
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(208318);
    new JceDisplayer(paramStringBuilder, paramInt).display(this.dYF, "_data");
    AppMethodBeat.o(208318);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(208306);
    boolean bool = JceUtil.equals(Integer.valueOf(1), ((b)paramObject).dYF);
    AppMethodBeat.o(208306);
    return bool;
  }
  
  public <T> void j(String paramString, T paramT)
  {
    AppMethodBeat.i(208299);
    if (paramString == null)
    {
      paramString = new IllegalArgumentException("put key can not is null");
      AppMethodBeat.o(208299);
      throw paramString;
    }
    if (paramT == null)
    {
      paramString = new IllegalArgumentException("put value can not is null");
      AppMethodBeat.o(208299);
      throw paramString;
    }
    if ((paramT instanceof Set))
    {
      paramString = new IllegalArgumentException("can not support Set");
      AppMethodBeat.o(208299);
      throw paramString;
    }
    Object localObject = new JceOutputStream();
    ((JceOutputStream)localObject).setServerEncoding(this.dYI);
    ((JceOutputStream)localObject).write(paramT, 0);
    localObject = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    HashMap localHashMap = new HashMap(1);
    ArrayList localArrayList = new ArrayList(1);
    e(localArrayList, paramT);
    localHashMap.put(a.g(localArrayList), localObject);
    this.dYH.remove(paramString);
    this.dYF.put(paramString, localHashMap);
    AppMethodBeat.o(208299);
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(208315);
    this.dYF.clear();
    HashMap localHashMap = new HashMap();
    byte[] arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = Byte.valueOf(0).byteValue();
    localHashMap.put("", arrayOfByte);
    this.dYF.put("", localHashMap);
    this.dYF = ((HashMap)paramJceInputStream.read(this.dYF, 0, true));
    AppMethodBeat.o(208315);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(208312);
    paramJceOutputStream.write(this.dYF, 0);
    AppMethodBeat.o(208312);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.qq.a.a.b
 * JD-Core Version:    0.7.0.1
 */