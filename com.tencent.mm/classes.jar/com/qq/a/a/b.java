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
  protected HashMap<String, HashMap<String, byte[]>> cig;
  private HashMap<String, Object> cih;
  private HashMap<String, Object> cii;
  protected String cij;
  JceInputStream cik;
  
  static
  {
    AppMethodBeat.i(186363);
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(186363);
      return;
    }
  }
  
  public b()
  {
    AppMethodBeat.i(186349);
    this.cig = new HashMap();
    this.cih = new HashMap(128);
    this.cii = new HashMap(128);
    this.cij = "GBK";
    this.cik = new JceInputStream();
    AppMethodBeat.o(186349);
  }
  
  private void c(ArrayList<String> paramArrayList, Object paramObject)
  {
    AppMethodBeat.i(186343);
    for (;;)
    {
      if (paramObject.getClass().isArray())
      {
        if (!paramObject.getClass().getComponentType().toString().equals("byte"))
        {
          paramArrayList = new IllegalArgumentException("only byte[] is supported");
          AppMethodBeat.o(186343);
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
          AppMethodBeat.o(186343);
        }
      }
      else
      {
        if ((paramObject instanceof Array))
        {
          paramArrayList = new IllegalArgumentException("can not support Array, please use List");
          AppMethodBeat.o(186343);
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
            AppMethodBeat.o(186343);
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
    AppMethodBeat.o(186343);
    return;
    label257:
    paramArrayList.add(paramObject.getClass().getName());
    AppMethodBeat.o(186343);
  }
  
  public byte[] Km()
  {
    AppMethodBeat.i(186346);
    Object localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.cij);
    ((JceOutputStream)localObject).write(this.cig, 0);
    localObject = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    AppMethodBeat.o(186346);
    return localObject;
  }
  
  public <T> void c(String paramString, T paramT)
  {
    AppMethodBeat.i(186340);
    if (paramString == null)
    {
      paramString = new IllegalArgumentException("put key can not is null");
      AppMethodBeat.o(186340);
      throw paramString;
    }
    if (paramT == null)
    {
      paramString = new IllegalArgumentException("put value can not is null");
      AppMethodBeat.o(186340);
      throw paramString;
    }
    if ((paramT instanceof Set))
    {
      paramString = new IllegalArgumentException("can not support Set");
      AppMethodBeat.o(186340);
      throw paramString;
    }
    Object localObject = new JceOutputStream();
    ((JceOutputStream)localObject).setServerEncoding(this.cij);
    ((JceOutputStream)localObject).write(paramT, 0);
    localObject = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    HashMap localHashMap = new HashMap(1);
    ArrayList localArrayList = new ArrayList(1);
    c(localArrayList, paramT);
    localHashMap.put(a.d(localArrayList), localObject);
    this.cii.remove(paramString);
    this.cig.put(paramString, localHashMap);
    AppMethodBeat.o(186340);
  }
  
  public Object clone()
  {
    AppMethodBeat.i(186355);
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
      AppMethodBeat.o(186355);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(186355);
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(186361);
    new JceDisplayer(paramStringBuilder, paramInt).display(this.cig, "_data");
    AppMethodBeat.o(186361);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(186353);
    boolean bool = JceUtil.equals(Integer.valueOf(1), ((b)paramObject).cig);
    AppMethodBeat.o(186353);
    return bool;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    AppMethodBeat.i(186359);
    this.cig.clear();
    HashMap localHashMap = new HashMap();
    byte[] arrayOfByte = (byte[])new byte[1];
    ((byte[])arrayOfByte)[0] = Byte.valueOf(0).byteValue();
    localHashMap.put("", arrayOfByte);
    this.cig.put("", localHashMap);
    this.cig = ((HashMap)paramJceInputStream.read(this.cig, 0, true));
    AppMethodBeat.o(186359);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    AppMethodBeat.i(186357);
    paramJceOutputStream.write(this.cig, 0);
    AppMethodBeat.o(186357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.qq.a.a.b
 * JD-Core Version:    0.7.0.1
 */