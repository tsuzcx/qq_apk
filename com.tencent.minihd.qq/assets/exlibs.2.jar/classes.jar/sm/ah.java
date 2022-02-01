package sm;

import android.content.Context;
import com.qq.jce.wup.UniPacket;
import com.tencent.securemodule.jni.TccCryptor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ah
{
  private static ah a;
  private Context b;
  private ag c;
  
  private ah(Context paramContext)
  {
    this.b = paramContext;
    this.c = new ag(paramContext);
  }
  
  private int a(int paramInt, UniPacket paramUniPacket1, UniPacket paramUniPacket2)
  {
    paramUniPacket1.setRequestId(paramInt);
    paramUniPacket1.setServantName(ag.a(paramInt));
    paramUniPacket1.setFuncName(ag.b(paramInt));
    paramUniPacket1.setEncodeName("UTF-8");
    paramUniPacket2.setEncodeName("UTF-8");
    return this.c.d();
  }
  
  private int a(UniPacket paramUniPacket1, UniPacket paramUniPacket2, boolean paramBoolean)
  {
    int i;
    try
    {
      paramUniPacket1 = paramUniPacket1.encode();
      Object localObject = TccCryptor.encrypt(this.b, paramUniPacket1, null);
      paramUniPacket1 = new af(this.b);
      i = paramUniPacket1.a(this.b, "http://pmir.3g.qq.com", (byte[])localObject);
      if (i != 0) {
        return i;
      }
      localObject = new AtomicReference();
      int j = paramUniPacket1.a(false, (AtomicReference)localObject);
      i = j;
      if (j == 0)
      {
        paramUniPacket1 = (byte[])((AtomicReference)localObject).get();
        if ((paramUniPacket1 != null) && (paramUniPacket1.length > 0)) {
          paramUniPacket2.decode(TccCryptor.decrypt(this.b, paramUniPacket1, null));
        }
        return 0;
      }
    }
    catch (IllegalArgumentException paramUniPacket1)
    {
      paramUniPacket1.printStackTrace();
      return -6057;
    }
    catch (Exception paramUniPacket1)
    {
      i = -6000;
      paramUniPacket1.printStackTrace();
    }
    return i;
  }
  
  public static ah a(Context paramContext)
  {
    if (a == null) {
      a = new ah(paramContext);
    }
    return a;
  }
  
  public int a(String paramString)
  {
    UniPacket localUniPacket = new UniPacket(true);
    int i = a(5, localUniPacket, new UniPacket(true));
    if (i != 0) {
      return i;
    }
    ArrayList localArrayList = new ArrayList();
    o localo = new o();
    localo.a = 28868;
    localo.c = "1";
    localo.b = ((int)(System.currentTimeMillis() / 1000L));
    localo.e = paramString;
    localArrayList.add(localo);
    localUniPacket.put("suikey", this.c.b());
    localUniPacket.put("vecsui", localArrayList);
    return a(localArrayList);
  }
  
  public int a(ArrayList<o> paramArrayList)
  {
    UniPacket localUniPacket1 = new UniPacket(true);
    UniPacket localUniPacket2 = new UniPacket(true);
    int i = a(5, localUniPacket1, localUniPacket2);
    if (i != 0) {
      return i;
    }
    localUniPacket1.put("suikey", this.c.b());
    localUniPacket1.put("vecsui", paramArrayList);
    return a(localUniPacket1, localUniPacket2, false);
  }
  
  public int a(ArrayList<d> paramArrayList, ArrayList<f> paramArrayList1)
  {
    UniPacket localUniPacket2 = new UniPacket(true);
    UniPacket localUniPacket1 = new UniPacket(true);
    int i = a(3, localUniPacket2, localUniPacket1);
    if (i != 0) {}
    int j;
    do
    {
      return i;
      localUniPacket2.put("phonetype", this.c.a());
      localUniPacket2.put("userinfo", this.c.c());
      localUniPacket2.put("vecCloudFeature", paramArrayList);
      j = a(localUniPacket2, localUniPacket1, false);
      i = j;
    } while (j != 0);
    paramArrayList = new ArrayList();
    paramArrayList.add(new f());
    paramArrayList = (ArrayList)localUniPacket1.getByClass("vecCloudResult", paramArrayList);
    if (paramArrayList != null)
    {
      paramArrayList1.clear();
      paramArrayList1.addAll(paramArrayList);
    }
    return 0;
  }
  
  public int a(List<b> paramList, AtomicReference<q> paramAtomicReference)
  {
    UniPacket localUniPacket1 = new UniPacket(true);
    UniPacket localUniPacket2 = new UniPacket(true);
    int i = a(1, localUniPacket1, localUniPacket2);
    if (i != 0) {}
    int j;
    do
    {
      return i;
      localUniPacket1.put("phonetype", this.c.a());
      localUniPacket1.put("userinfo", this.c.c());
      localUniPacket1.put("vecclient", paramList);
      j = a(localUniPacket1, localUniPacket2, false);
      i = j;
    } while (j != 0);
    paramList = (q)localUniPacket2.getByClass("cmdinfo", new q());
    if (paramList != null) {
      paramAtomicReference.set(paramList);
    }
    return 0;
  }
  
  public int a(h paramh, AtomicReference<j> paramAtomicReference)
  {
    UniPacket localUniPacket1 = new UniPacket(true);
    UniPacket localUniPacket2 = new UniPacket(true);
    localUniPacket1.setRequestId(0);
    localUniPacket1.setServantName(ag.a(0));
    localUniPacket1.setFuncName(ag.b(0));
    localUniPacket1.setEncodeName("UTF-8");
    localUniPacket2.setEncodeName("UTF-8");
    localUniPacket1.put("phonetype", this.c.a());
    localUniPacket1.put("userinfo", this.c.c());
    localUniPacket1.put("deviceinfo", paramh);
    int i = a(localUniPacket1, localUniPacket2, false);
    if (i != 0) {
      return i;
    }
    paramh = (j)localUniPacket2.getByClass("guidinfo", new j());
    if (paramh != null) {
      paramAtomicReference.set(paramh);
    }
    return 0;
  }
  
  public int b(ArrayList<g> paramArrayList, ArrayList<f> paramArrayList1)
  {
    UniPacket localUniPacket2 = new UniPacket(true);
    UniPacket localUniPacket1 = new UniPacket(true);
    int i = a(4, localUniPacket2, localUniPacket1);
    if (i != 0) {}
    int j;
    do
    {
      return i;
      localUniPacket2.put("phonetype", this.c.a());
      localUniPacket2.put("userinfo", this.c.c());
      localUniPacket2.put("vecDetailCloudFeature", paramArrayList);
      j = a(localUniPacket2, localUniPacket1, false);
      i = j;
    } while (j != 0);
    paramArrayList = new ArrayList();
    paramArrayList.add(new f());
    paramArrayList = (ArrayList)localUniPacket1.getByClass("vecCloudResult", paramArrayList);
    if (paramArrayList != null)
    {
      paramArrayList1.clear();
      paramArrayList1.addAll(paramArrayList);
    }
    return 0;
  }
  
  static class a
  {
    int a;
    String b;
    String c;
    
    public a(int paramInt, String paramString1, String paramString2)
    {
      this.a = paramInt;
      this.b = paramString1;
      this.c = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     sm.ah
 * JD-Core Version:    0.7.0.1
 */