package c.t.m.g;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;

public final class bc
{
  private static HashMap e = null;
  public bd a = new bd();
  private HashMap b = new HashMap();
  private az c = new az();
  private String d = "GBK";
  
  public final void a(int paramInt)
  {
    this.a.b = paramInt;
  }
  
  public final void a(String paramString)
  {
    this.a.d = paramString;
  }
  
  public final void a(String paramString, Object paramObject)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("put key can not is null");
    }
    if (paramObject == null) {
      throw new IllegalArgumentException("put value can not is null");
    }
    if ((paramObject instanceof Set)) {
      throw new IllegalArgumentException("can not support Set");
    }
    Object localObject = new ba();
    ((ba)localObject).a(this.d);
    ((ba)localObject).a(paramObject, 0);
    paramObject = ((ba)localObject).a();
    localObject = new byte[paramObject.position()];
    System.arraycopy(paramObject.array(), 0, localObject, 0, localObject.length);
    this.b.put(paramString, localObject);
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < 4) {
      throw new IllegalArgumentException("decode package must include size head");
    }
    try
    {
      paramArrayOfByte = new az(paramArrayOfByte, (byte)0);
      paramArrayOfByte.b = this.d;
      this.a.a(paramArrayOfByte);
      paramArrayOfByte = new az(this.a.e);
      paramArrayOfByte.b = this.d;
      if (e == null)
      {
        localHashMap = new HashMap();
        e = localHashMap;
        localHashMap.put("", new byte[0]);
      }
      HashMap localHashMap = e;
      this.b = ((HashMap)paramArrayOfByte.a(new HashMap(), localHashMap, 0, false));
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  public final byte[] a()
  {
    Object localObject2 = new ba(0);
    ((ba)localObject2).a(this.d);
    ((ba)localObject2).a(this.b, 0);
    this.a.a = 3;
    Object localObject1 = this.a;
    localObject2 = ((ba)localObject2).a();
    byte[] arrayOfByte = new byte[((ByteBuffer)localObject2).position()];
    System.arraycopy(((ByteBuffer)localObject2).array(), 0, arrayOfByte, 0, arrayOfByte.length);
    ((bd)localObject1).e = arrayOfByte;
    localObject1 = new ba(0);
    ((ba)localObject1).a(this.d);
    this.a.a((ba)localObject1);
    localObject2 = ((ba)localObject1).a();
    localObject1 = new byte[((ByteBuffer)localObject2).position()];
    System.arraycopy(((ByteBuffer)localObject2).array(), 0, localObject1, 0, localObject1.length);
    int i = localObject1.length;
    localObject2 = ByteBuffer.allocate(i + 4);
    ((ByteBuffer)localObject2).putInt(i + 4).put((byte[])localObject1).flip();
    return ((ByteBuffer)localObject2).array();
  }
  
  public final Object b(String paramString, Object paramObject)
    throws Exception
  {
    if (!this.b.containsKey(paramString)) {
      return null;
    }
    paramString = (byte[])this.b.get(paramString);
    try
    {
      this.c.a = ByteBuffer.wrap(paramString);
      this.c.b = this.d;
      paramString = this.c.a(paramObject, 0, true);
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new Exception(paramString);
    }
  }
  
  public final void b(String paramString)
  {
    this.a.c = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     c.t.m.g.bc
 * JD-Core Version:    0.7.0.1
 */