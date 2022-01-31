package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.ipcall.a.e.e;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.c.ams;
import com.tencent.mm.protocal.c.chu;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.i.a.a;
import com.tencent.mm.ui.i.a.c;
import com.tencent.mm.ui.s;
import java.util.HashMap;

public class IPCallShareCouponCardUI
  extends MMActivity
  implements f, a.a, com.tencent.mm.ui.i.a.b
{
  private String dkv = null;
  private ProgressDialog dnm = null;
  private View jd;
  private ProgressDialog luI = null;
  private TextView lxS;
  private TextView lxT;
  private TextView lxU;
  private TextView lxV;
  private Button lxW;
  private ImageView lxX;
  private com.tencent.mm.ui.i.a lxY = new com.tencent.mm.ui.i.a();
  private ProgressDialog lxZ = null;
  private i lya = null;
  private ImageView lyb = null;
  private ProgressBar lyc = null;
  private e lyd = new e();
  private String lye = null;
  private String lyf = null;
  private String lyg = null;
  private String lyh = null;
  private String lyi = null;
  private String lyj = null;
  private String lyk = null;
  private String lyl = null;
  private String lym = null;
  private chu lyn = null;
  private String lyo = null;
  private View lyp;
  private int mFrom = 0;
  private String mTitle = null;
  
  public static String F(Context paramContext, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(8), paramContext.getString(R.l.ip_call_share_copy_invite_url_tip));
    localHashMap.put(Integer.valueOf(0), paramContext.getString(R.l.wechat_friend));
    localHashMap.put(Integer.valueOf(1), paramContext.getString(R.l.ip_call_share_timeline_tip));
    localHashMap.put(Integer.valueOf(3), paramContext.getString(R.l.ip_call_share_email_tip));
    localHashMap.put(Integer.valueOf(2), paramContext.getString(R.l.ip_call_share_sms_tip));
    localHashMap.put(Integer.valueOf(5), paramContext.getString(R.l.ip_call_share_twitter_tip));
    localHashMap.put(Integer.valueOf(4), paramContext.getString(R.l.ip_call_share_whatsapp_tip));
    localHashMap.put(Integer.valueOf(6), paramContext.getString(R.l.ip_call_share_facebook_tip));
    localHashMap.put(Integer.valueOf(7), paramContext.getString(R.l.ip_call_share_facebook_messenger_tip));
    if (localHashMap.containsKey(Integer.valueOf(paramInt))) {
      return (String)localHashMap.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  /* Error */
  private static byte[] FR(String paramString)
  {
    // Byte code:
    //   0: invokestatic 179	com/tencent/mm/model/au:Hx	()Lcom/tencent/mm/model/c;
    //   3: pop
    //   4: invokestatic 185	com/tencent/mm/model/c:FG	()Ljava/lang/String;
    //   7: astore_1
    //   8: invokestatic 179	com/tencent/mm/model/au:Hx	()Lcom/tencent/mm/model/c;
    //   11: pop
    //   12: aload_1
    //   13: invokestatic 188	com/tencent/mm/model/c:FH	()Ljava/lang/String;
    //   16: ldc 190
    //   18: aload_0
    //   19: invokevirtual 194	java/lang/String:getBytes	()[B
    //   22: invokestatic 200	com/tencent/mm/a/g:o	([B)Ljava/lang/String;
    //   25: ldc 202
    //   27: invokestatic 208	com/tencent/mm/sdk/platformtools/h:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   30: astore_0
    //   31: aload_0
    //   32: invokestatic 214	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   35: ifeq +12 -> 47
    //   38: ldc 216
    //   40: ldc 218
    //   42: invokestatic 223	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aconst_null
    //   46: areturn
    //   47: new 225	java/io/RandomAccessFile
    //   50: dup
    //   51: aload_0
    //   52: ldc 227
    //   54: invokespecial 229	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: astore_1
    //   58: aload_1
    //   59: astore_0
    //   60: aload_1
    //   61: invokevirtual 233	java/io/RandomAccessFile:length	()J
    //   64: l2i
    //   65: newarray byte
    //   67: astore_2
    //   68: aload_1
    //   69: astore_0
    //   70: aload_1
    //   71: aload_2
    //   72: invokevirtual 237	java/io/RandomAccessFile:read	([B)I
    //   75: pop
    //   76: aload_1
    //   77: invokevirtual 240	java/io/RandomAccessFile:close	()V
    //   80: aload_2
    //   81: areturn
    //   82: astore_2
    //   83: aconst_null
    //   84: astore_1
    //   85: aload_1
    //   86: astore_0
    //   87: ldc 216
    //   89: aload_2
    //   90: ldc 242
    //   92: iconst_0
    //   93: anewarray 244	java/lang/Object
    //   96: invokestatic 248	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   99: aload_1
    //   100: ifnull -55 -> 45
    //   103: aload_1
    //   104: invokevirtual 240	java/io/RandomAccessFile:close	()V
    //   107: aconst_null
    //   108: areturn
    //   109: astore_0
    //   110: aconst_null
    //   111: areturn
    //   112: astore_1
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_0
    //   116: ifnull +7 -> 123
    //   119: aload_0
    //   120: invokevirtual 240	java/io/RandomAccessFile:close	()V
    //   123: aload_1
    //   124: athrow
    //   125: astore_0
    //   126: goto -46 -> 80
    //   129: astore_0
    //   130: goto -7 -> 123
    //   133: astore_1
    //   134: goto -19 -> 115
    //   137: astore_2
    //   138: goto -53 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramString	String
    //   7	97	1	localObject1	Object
    //   112	12	1	localObject2	Object
    //   133	1	1	localObject3	Object
    //   67	14	2	arrayOfByte	byte[]
    //   82	8	2	localException1	java.lang.Exception
    //   137	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   47	58	82	java/lang/Exception
    //   103	107	109	java/lang/Exception
    //   47	58	112	finally
    //   76	80	125	java/lang/Exception
    //   119	123	129	java/lang/Exception
    //   60	68	133	finally
    //   70	76	133	finally
    //   87	99	133	finally
    //   60	68	137	java/lang/Exception
    //   70	76	137	java/lang/Exception
  }
  
  public static void a(Context paramContext, int paramInt, TextView paramTextView, ImageView paramImageView)
  {
    paramContext = F(paramContext, paramInt);
    if (paramContext != null) {
      paramTextView.setText(paramContext);
    }
    paramInt = sR(paramInt);
    if (paramInt != -1) {
      paramImageView.setImageResource(paramInt);
    }
  }
  
  private static boolean au(Context paramContext, String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    try
    {
      paramContext.getPackageManager().getApplicationInfo(paramString, 8192);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  private static Bitmap bdf()
  {
    byte[] arrayOfByte = FR(q.Gj());
    if (arrayOfByte == null) {
      return null;
    }
    return com.tencent.mm.sdk.platformtools.c.bu(arrayOfByte);
  }
  
  private void m(int paramInt, String paramString1, String paramString2)
  {
    this.lyp = View.inflate(this.mController.uMN, R.i.confirm_dialog_item, null);
    EditText localEditText = (EditText)this.lyp.findViewById(R.h.confirm_dialog_text_et);
    this.lyb = ((ImageView)this.lyp.findViewById(R.h.confirm_dialog_imageview));
    this.lyc = ((ProgressBar)this.lyp.findViewById(R.h.loading_pb));
    localEditText.setText(paramString1);
    Object localObject = bdf();
    if (localObject == null)
    {
      localObject = q.Gj();
      au.Hx();
      localObject = new com.tencent.mm.ba.a((String)localObject, bk.g((Integer)com.tencent.mm.model.c.Dz().get(66561, null)));
      au.Dk().a((m)localObject, 0);
      this.lyc.setVisibility(0);
    }
    for (;;)
    {
      com.tencent.mm.pluginsdk.ui.applet.g.a(this.mController, paramString2, this.lyp, getResources().getString(R.l.app_send), new IPCallShareCouponCardUI.5(this, localEditText, paramString1, paramInt));
      return;
      if (this.lyb != null) {
        this.lyb.setImageBitmap((Bitmap)localObject);
      }
    }
  }
  
  public static int sR(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(8), Integer.valueOf(R.k.bottomsheet_copy));
    localHashMap.put(Integer.valueOf(0), Integer.valueOf(R.k.bottomsheet_repost));
    localHashMap.put(Integer.valueOf(1), Integer.valueOf(R.k.bottomsheet_moment));
    localHashMap.put(Integer.valueOf(3), Integer.valueOf(R.k.bottomsheet_email));
    localHashMap.put(Integer.valueOf(2), Integer.valueOf(R.k.bottomsheet_sms));
    localHashMap.put(Integer.valueOf(5), Integer.valueOf(R.k.bottomsheet_twitter));
    localHashMap.put(Integer.valueOf(4), Integer.valueOf(R.k.bottomsheet_whatsapp));
    localHashMap.put(Integer.valueOf(6), Integer.valueOf(R.k.bottomsheet_facebook));
    localHashMap.put(Integer.valueOf(7), Integer.valueOf(R.k.bottomsheet_messenger));
    if (localHashMap.containsKey(Integer.valueOf(paramInt))) {
      return ((Integer)localHashMap.get(Integer.valueOf(paramInt))).intValue();
    }
    return -1;
  }
  
  private void sS(int paramInt)
  {
    h.a(this.mController.uMN, paramInt, R.l.app_tip, new IPCallShareCouponCardUI.14(this), new IPCallShareCouponCardUI.15(this));
  }
  
  public final void a(a.c paramc)
  {
    if (this.lxZ != null) {
      this.lxZ.cancel();
    }
    switch (IPCallShareCouponCardUI.8.lyx[paramc.ordinal()])
    {
    case 2: 
    default: 
      return;
    case 1: 
      sS(R.l.twitterlogin_success);
      return;
    }
    sS(R.l.twitterlogin_failed);
  }
  
  public final void b(a.c paramc) {}
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.ip_call_coupons_share_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      if (!bk.bl(paramIntent)) {
        com.tencent.mm.pluginsdk.ui.applet.g.a(this.mController, this.mTitle, this.lyf, this.dkv, true, getResources().getString(R.l.app_send), new IPCallShareCouponCardUI.7(this, paramIntent));
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(R.l.ipcall_share_coupon_card_title);
    setBackBtn(new IPCallShareCouponCardUI.1(this));
    this.jd = findViewById(R.h.layout);
    this.lxS = ((TextView)findViewById(R.h.coupon_money_tv));
    this.lxT = ((TextView)findViewById(R.h.data_wording_tv));
    this.lxU = ((TextView)findViewById(R.h.coupon_big_tips_tv));
    this.lxV = ((TextView)findViewById(R.h.coupon_small_tips_tv));
    this.lxW = ((Button)findViewById(R.h.share_btn));
    this.lxX = ((ImageView)findViewById(R.h.header_icon));
    this.jd.setVisibility(8);
    com.tencent.mm.pluginsdk.ui.a.b.a(this.lxX, q.Gj(), 0.5F, false);
    paramBundle = this.mController.uMN;
    getString(R.l.app_tip);
    this.luI = h.b(paramBundle, getString(R.l.ip_call_loading_tip), true, new IPCallShareCouponCardUI.9(this));
    com.tencent.mm.plugin.ipcall.a.f.b.bcJ().gZ(false);
    this.mFrom = getIntent().getIntExtra("IPCallShareCouponCardUI_KFrom", 0);
    au.Dk().a(257, this);
    au.Dk().a(1804, this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    au.Dk().b(257, this);
    au.Dk().b(1804, this);
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    String str;
    Object localObject1;
    label293:
    Object localObject2;
    if ((paramm instanceof com.tencent.mm.plugin.ipcall.a.d.g)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.jd.setVisibility(0);
        paramString = com.tencent.mm.plugin.ipcall.b.c.bdt();
        if (paramString != null)
        {
          this.lye = paramString.tiD;
          this.dkv = paramString.kRN;
          this.lyf = paramString.tiE;
          this.mTitle = paramString.bGw;
          this.lyg = paramString.lsL;
          this.lyh = paramString.tiF;
          this.lyj = paramString.tiG;
          this.lyk = paramString.tiH;
          this.lyl = paramString.tiI;
          this.lym = paramString.tiK;
          this.lyn = paramString.tiJ;
          this.lyo = paramString.tiL;
        }
        this.lxS.setText(this.lym);
        this.lxT.setText(String.format(this.mController.uMN.getString(R.l.ipcall_share_coupon_card_code_desc), new Object[] { this.lye }));
        this.lxW.setOnClickListener(new IPCallShareCouponCardUI.11(this));
        this.lxU.setText(String.format(getString(R.l.ipcall_share_coupon_card_content_title), new Object[] { this.lym }));
        paramm = this.lxV;
        str = String.format(getString(R.l.ipcall_share_coupon_card_content_desc), new Object[] { this.lym });
        localObject1 = getString(R.l.ipcall_share_coupon_card_rule);
        if (bk.bl((String)localObject1))
        {
          paramm.setText(str);
          if ((this.luI != null) && (this.luI.isShowing())) {
            this.luI.dismiss();
          }
          return;
        }
        paramString = getString(R.l.ipcall_share_coupon_promotion_desc);
        localObject2 = paramm.getPaint();
        float f1 = ((TextPaint)localObject2).measureText(str);
        float f2 = ((TextPaint)localObject2).measureText(paramString);
        paramInt1 = com.tencent.mm.cb.a.fj(this.mController.uMN);
        paramInt2 = ((LinearLayout.LayoutParams)paramm.getLayoutParams()).leftMargin;
        paramInt1 -= ((LinearLayout.LayoutParams)paramm.getLayoutParams()).rightMargin + paramInt2;
        paramInt2 = (int)Math.ceil(f1 / paramInt1);
        int i = (int)Math.ceil((f1 + f2) / paramInt1);
        paramInt1 = paramInt2;
        if (paramInt2 == 0) {
          paramInt1 = 1;
        }
        if (i <= paramInt1) {
          break label715;
        }
        paramString = "\n" + paramString;
      }
    }
    label715:
    for (;;)
    {
      paramm.setGravity(17);
      localObject2 = Spannable.Factory.getInstance().newSpannable(str + paramString);
      localObject1 = new IPCallShareCouponCardUI.6(this, (String)localObject1);
      paramInt1 = str.length();
      paramInt2 = str.length();
      ((Spannable)localObject2).setSpan(localObject1, paramInt1, paramString.length() + paramInt2, 33);
      paramm.setText((CharSequence)localObject2);
      paramm.setMovementMethod(LinkMovementMethod.getInstance());
      break;
      if ((this.luI == null) || (!this.luI.isShowing())) {
        break label293;
      }
      this.luI.dismiss();
      h.a(this.mController.uMN, getString(R.l.ip_call_load_error_tip), getString(R.l.ip_call_func_name), new IPCallShareCouponCardUI.10(this));
      return;
      if ((paramm instanceof com.tencent.mm.modelmulti.g))
      {
        if (this.dnm != null)
        {
          this.dnm.dismiss();
          this.dnm = null;
        }
        if (com.tencent.mm.plugin.subapp.b.eUS.b(this.mController.uMN, paramInt1, paramInt2, paramString)) {
          break label293;
        }
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          h.h(this.mController.uMN, R.l.sendrequest_send_fail, R.l.app_tip);
          return;
        }
        h.bC(this, getResources().getString(R.l.confirm_dialog_sent));
        return;
      }
      if ((!(paramm instanceof com.tencent.mm.ba.a)) || (paramInt1 != 0) || (paramInt2 != 0) || (this.lyb == null)) {
        break label293;
      }
      if (this.lyc != null) {
        this.lyc.setVisibility(8);
      }
      this.lyb.setImageBitmap(bdf());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI
 * JD-Core Version:    0.7.0.1
 */