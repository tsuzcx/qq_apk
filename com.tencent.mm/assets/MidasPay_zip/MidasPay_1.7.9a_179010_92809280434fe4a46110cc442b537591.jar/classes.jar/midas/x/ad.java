package midas.x;

import java.io.ObjectInputStream;
import java.io.ObjectInputStream.GetField;
import java.io.ObjectOutputStream;
import java.io.ObjectOutputStream.PutField;
import java.io.Serializable;
import java.util.concurrent.CopyOnWriteArrayList;

public class ad
  implements Serializable
{
  public static final long serialVersionUID = 1L;
  public volatile String a;
  public volatile Long b;
  public volatile Long c;
  public volatile Long d;
  public CopyOnWriteArrayList<zc> e;
  
  public ad(String paramString)
  {
    this.a = paramString;
    paramString = Long.valueOf(0L);
    this.b = paramString;
    this.c = paramString;
    this.d = Long.valueOf(System.currentTimeMillis());
    this.e = new CopyOnWriteArrayList();
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("readObject() in = ");
    localStringBuilder.append(paramObjectInputStream);
    ed.a("NetworkNode", localStringBuilder.toString());
    try
    {
      paramObjectInputStream = paramObjectInputStream.readFields();
      this.a = bd.a((String)paramObjectInputStream.get("identifier", bd.b("default")));
      this.b = Long.valueOf(bd.a((String)paramObjectInputStream.get("updatetime", bd.b("0"))));
      this.c = Long.valueOf(bd.a((String)paramObjectInputStream.get("measuretime", bd.b("0"))));
      this.d = Long.valueOf(bd.a((String)paramObjectInputStream.get("accesstime", bd.b("0"))));
      this.e = ((CopyOnWriteArrayList)paramObjectInputStream.get("ips", new CopyOnWriteArrayList()));
      return;
    }
    catch (Exception paramObjectInputStream)
    {
      paramObjectInputStream.printStackTrace();
    }
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("writeObject() out = ");
    ((StringBuilder)localObject).append(paramObjectOutputStream);
    ed.a("NetworkNode", ((StringBuilder)localObject).toString());
    try
    {
      localObject = paramObjectOutputStream.putFields();
      ((ObjectOutputStream.PutField)localObject).put("identifier", bd.b(this.a));
      ((ObjectOutputStream.PutField)localObject).put("updatetime", bd.b(String.valueOf(this.b)));
      ((ObjectOutputStream.PutField)localObject).put("measuretime", bd.b(String.valueOf(this.c)));
      ((ObjectOutputStream.PutField)localObject).put("accesstime", bd.b(String.valueOf(this.d)));
      ((ObjectOutputStream.PutField)localObject).put("ips", this.e);
      paramObjectOutputStream.writeFields();
      return;
    }
    catch (Exception paramObjectOutputStream)
    {
      paramObjectOutputStream.printStackTrace();
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = paramObject instanceof ad;
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    paramObject = (ad)paramObject;
    if (this.a != null) {
      return this.a.equals(paramObject.a);
    }
    if (paramObject.a == null) {
      bool1 = true;
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append(this.a);
    localStringBuilder.append("->(");
    localStringBuilder.append(this.b);
    localStringBuilder.append(":");
    localStringBuilder.append(this.c);
    localStringBuilder.append(":");
    localStringBuilder.append(this.d);
    localStringBuilder.append(")=>");
    localStringBuilder.append(this.e.toString());
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.ad
 * JD-Core Version:    0.7.0.1
 */