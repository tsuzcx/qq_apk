package midas.x;

import android.text.TextUtils;
import com.pay.tool.APTools;
import com.tencent.midas.plugin.APPluginUtils;
import java.util.ArrayList;

public class fa
{
  public String a;
  public String b;
  public String c;
  public String d;
  public boolean e;
  public ArrayList<ez> f = new ArrayList();
  private int g;
  
  public fa(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramBoolean;
    this.g = -1;
  }
  
  public boolean a()
  {
    if (!this.e) {
      return true;
    }
    return APPluginUtils.getInstallPath(a.a().d, this.c) != null;
  }
  
  public boolean b()
  {
    boolean bool2 = TextUtils.isEmpty(this.c);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (this.g == -1) {
      this.g = (APTools.m(this.c) ^ true);
    }
    if (this.g == 0) {
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.fa
 * JD-Core Version:    0.7.0.1
 */