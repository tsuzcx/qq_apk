package midas.x;

import android.text.TextUtils;
import com.pay.tool.APTools;
import com.tencent.midas.plugin.APPluginUtils;
import java.util.ArrayList;

public class m5
{
  public String a;
  public String b;
  public String c;
  public boolean d;
  public int e;
  public ArrayList<l5> f = new ArrayList();
  
  public m5(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    this.a = paramString2;
    this.b = paramString3;
    this.c = paramString4;
    this.d = paramBoolean;
    this.e = -1;
  }
  
  public boolean a()
  {
    boolean bool2 = TextUtils.isEmpty(this.b);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (this.e == -1) {
      this.e = (APTools.a(this.b) ^ true);
    }
    if (this.e == 0) {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean b()
  {
    if (!this.d) {
      return true;
    }
    return APPluginUtils.getInstallPath(a.r().d, this.b) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.m5
 * JD-Core Version:    0.7.0.1
 */