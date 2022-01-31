package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.ipcall.a.e.e;
import com.tencent.mm.protocal.protobuf.ash;
import com.tencent.mm.protocal.protobuf.cvf;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.j.a.a;
import com.tencent.mm.ui.j.a.c;
import java.util.HashMap;

public class IPCallShareCouponCardUI
  extends MMActivity
  implements f, a.a, com.tencent.mm.ui.j.a.b
{
  private ProgressDialog eeN;
  private View jU;
  private String mDesc;
  private int mFrom;
  private String mTitle;
  private String mWording;
  private ProgressDialog nSa;
  private String nVA;
  private View nVB;
  private TextView nVf;
  private TextView nVg;
  private TextView nVh;
  private TextView nVi;
  private Button nVj;
  private ImageView nVk;
  private com.tencent.mm.ui.j.a nVl;
  private ProgressDialog nVm;
  private i nVn;
  private ImageView nVo;
  private ProgressBar nVp;
  private e nVq;
  private String nVr;
  private String nVs;
  private String nVt;
  private String nVu;
  private String nVv;
  private String nVw;
  private String nVx;
  private String nVy;
  private cvf nVz;
  
  public IPCallShareCouponCardUI()
  {
    AppMethodBeat.i(22297);
    this.nVl = new com.tencent.mm.ui.j.a();
    this.eeN = null;
    this.nVm = null;
    this.nVn = null;
    this.nSa = null;
    this.nVo = null;
    this.nVp = null;
    this.nVq = new e();
    this.nVr = null;
    this.mDesc = null;
    this.nVs = null;
    this.mTitle = null;
    this.mWording = null;
    this.nVt = null;
    this.nVu = null;
    this.nVv = null;
    this.nVw = null;
    this.nVx = null;
    this.nVy = null;
    this.nVz = null;
    this.nVA = null;
    this.mFrom = 0;
    AppMethodBeat.o(22297);
  }
  
  public static String R(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(22303);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(8), paramContext.getString(2131300884));
    localHashMap.put(Integer.valueOf(0), paramContext.getString(2131305942));
    localHashMap.put(Integer.valueOf(1), paramContext.getString(2131300889));
    localHashMap.put(Integer.valueOf(3), paramContext.getString(2131300885));
    localHashMap.put(Integer.valueOf(2), paramContext.getString(2131300888));
    localHashMap.put(Integer.valueOf(5), paramContext.getString(2131300890));
    localHashMap.put(Integer.valueOf(4), paramContext.getString(2131300891));
    localHashMap.put(Integer.valueOf(6), paramContext.getString(2131300887));
    localHashMap.put(Integer.valueOf(7), paramContext.getString(2131300886));
    if (localHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      paramContext = (String)localHashMap.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(22303);
      return paramContext;
    }
    AppMethodBeat.o(22303);
    return null;
  }
  
  /* Error */
  private static byte[] Rt(String paramString)
  {
    // Byte code:
    //   0: sipush 22309
    //   3: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 166	com/tencent/mm/model/aw:aaz	()Lcom/tencent/mm/model/c;
    //   9: pop
    //   10: invokestatic 172	com/tencent/mm/model/c:YK	()Ljava/lang/String;
    //   13: astore_1
    //   14: invokestatic 166	com/tencent/mm/model/aw:aaz	()Lcom/tencent/mm/model/c;
    //   17: pop
    //   18: aload_1
    //   19: invokestatic 175	com/tencent/mm/model/c:YL	()Ljava/lang/String;
    //   22: ldc 177
    //   24: aload_0
    //   25: invokevirtual 181	java/lang/String:getBytes	()[B
    //   28: invokestatic 187	com/tencent/mm/a/g:w	([B)Ljava/lang/String;
    //   31: ldc 189
    //   33: invokestatic 195	com/tencent/mm/sdk/platformtools/j:h	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   36: astore_0
    //   37: aload_0
    //   38: invokestatic 201	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   41: ifeq +18 -> 59
    //   44: ldc 203
    //   46: ldc 205
    //   48: invokestatic 211	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: sipush 22309
    //   54: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aconst_null
    //   58: areturn
    //   59: new 213	java/io/RandomAccessFile
    //   62: dup
    //   63: aload_0
    //   64: ldc 215
    //   66: invokespecial 217	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: astore_1
    //   70: aload_1
    //   71: astore_0
    //   72: aload_1
    //   73: invokevirtual 221	java/io/RandomAccessFile:length	()J
    //   76: l2i
    //   77: newarray byte
    //   79: astore_2
    //   80: aload_1
    //   81: astore_0
    //   82: aload_1
    //   83: aload_2
    //   84: invokevirtual 225	java/io/RandomAccessFile:read	([B)I
    //   87: pop
    //   88: aload_1
    //   89: invokevirtual 228	java/io/RandomAccessFile:close	()V
    //   92: sipush 22309
    //   95: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: aload_2
    //   99: areturn
    //   100: astore_2
    //   101: aconst_null
    //   102: astore_1
    //   103: aload_1
    //   104: astore_0
    //   105: ldc 203
    //   107: aload_2
    //   108: ldc 230
    //   110: iconst_0
    //   111: anewarray 232	java/lang/Object
    //   114: invokestatic 236	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: aload_1
    //   118: ifnull +7 -> 125
    //   121: aload_1
    //   122: invokevirtual 228	java/io/RandomAccessFile:close	()V
    //   125: sipush 22309
    //   128: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: aconst_null
    //   132: areturn
    //   133: astore_1
    //   134: aconst_null
    //   135: astore_0
    //   136: aload_0
    //   137: ifnull +7 -> 144
    //   140: aload_0
    //   141: invokevirtual 228	java/io/RandomAccessFile:close	()V
    //   144: sipush 22309
    //   147: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload_1
    //   151: athrow
    //   152: astore_0
    //   153: goto -61 -> 92
    //   156: astore_0
    //   157: goto -32 -> 125
    //   160: astore_0
    //   161: goto -17 -> 144
    //   164: astore_1
    //   165: goto -29 -> 136
    //   168: astore_2
    //   169: goto -66 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	paramString	String
    //   13	109	1	localObject1	Object
    //   133	18	1	localObject2	Object
    //   164	1	1	localObject3	Object
    //   79	20	2	arrayOfByte	byte[]
    //   100	8	2	localException1	java.lang.Exception
    //   168	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   59	70	100	java/lang/Exception
    //   59	70	133	finally
    //   88	92	152	java/lang/Exception
    //   121	125	156	java/lang/Exception
    //   140	144	160	java/lang/Exception
    //   72	80	164	finally
    //   82	88	164	finally
    //   105	117	164	finally
    //   72	80	168	java/lang/Exception
    //   82	88	168	java/lang/Exception
  }
  
  public static void a(Context paramContext, int paramInt, TextView paramTextView, ImageView paramImageView)
  {
    AppMethodBeat.i(22302);
    paramContext = R(paramContext, paramInt);
    if (paramContext != null) {
      paramTextView.setText(paramContext);
    }
    paramInt = xT(paramInt);
    if (paramInt != -1) {
      paramImageView.setImageResource(paramInt);
    }
    AppMethodBeat.o(22302);
  }
  
  private static boolean aD(Context paramContext, String paramString)
  {
    AppMethodBeat.i(22305);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(22305);
      return false;
    }
    try
    {
      paramContext.getPackageManager().getApplicationInfo(paramString, 8192);
      AppMethodBeat.o(22305);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(22305);
    }
    return false;
  }
  
  private static Bitmap bKp()
  {
    AppMethodBeat.i(22308);
    Object localObject = Rt(r.Zn());
    if (localObject == null)
    {
      AppMethodBeat.o(22308);
      return null;
    }
    localObject = d.bT((byte[])localObject);
    AppMethodBeat.o(22308);
    return localObject;
  }
  
  private void w(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(22310);
    this.nVB = View.inflate(getContext(), 2130969201, null);
    EditText localEditText = (EditText)this.nVB.findViewById(2131822990);
    this.nVo = ((ImageView)this.nVB.findViewById(2131822989));
    this.nVp = ((ProgressBar)this.nVB.findViewById(2131821643));
    localEditText.setText(paramString1);
    Object localObject = bKp();
    if (localObject == null)
    {
      localObject = r.Zn();
      aw.aaz();
      localObject = new com.tencent.mm.bb.a((String)localObject, bo.g((Integer)com.tencent.mm.model.c.Ru().get(66561, null)));
      aw.Rc().a((com.tencent.mm.ai.m)localObject, 0);
      this.nVp.setVisibility(0);
    }
    for (;;)
    {
      com.tencent.mm.pluginsdk.ui.applet.g.a(this.mController, paramString2, this.nVB, getResources().getString(2131297067), new IPCallShareCouponCardUI.5(this, localEditText, paramString1, paramInt));
      AppMethodBeat.o(22310);
      return;
      if (this.nVo != null) {
        this.nVo.setImageBitmap((Bitmap)localObject);
      }
    }
  }
  
  public static int xT(int paramInt)
  {
    AppMethodBeat.i(22304);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(8), Integer.valueOf(2131230998));
    localHashMap.put(Integer.valueOf(0), Integer.valueOf(2131231047));
    localHashMap.put(Integer.valueOf(1), Integer.valueOf(2131231046));
    localHashMap.put(Integer.valueOf(3), Integer.valueOf(2131230999));
    localHashMap.put(Integer.valueOf(2), Integer.valueOf(2131231048));
    localHashMap.put(Integer.valueOf(5), Integer.valueOf(2131231049));
    localHashMap.put(Integer.valueOf(4), Integer.valueOf(2131231050));
    localHashMap.put(Integer.valueOf(6), Integer.valueOf(2131231000));
    localHashMap.put(Integer.valueOf(7), Integer.valueOf(2131231045));
    if (localHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      paramInt = ((Integer)localHashMap.get(Integer.valueOf(paramInt))).intValue();
      AppMethodBeat.o(22304);
      return paramInt;
    }
    AppMethodBeat.o(22304);
    return -1;
  }
  
  private void xU(int paramInt)
  {
    AppMethodBeat.i(22307);
    h.a(getContext(), paramInt, 2131297087, new IPCallShareCouponCardUI.14(this), new IPCallShareCouponCardUI.15(this));
    AppMethodBeat.o(22307);
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(22306);
    if (this.nVm != null) {
      this.nVm.cancel();
    }
    switch (IPCallShareCouponCardUI.8.nVJ[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(22306);
      return;
      xU(2131304399);
      AppMethodBeat.o(22306);
      return;
      AppMethodBeat.o(22306);
      return;
      xU(2131304398);
    }
  }
  
  public final void b(a.c paramc) {}
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969926;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(22311);
    if ((paramInt1 == 1) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      if (!bo.isNullOrNil(paramIntent)) {
        com.tencent.mm.pluginsdk.ui.applet.g.a(getController(), this.mTitle, this.nVs, this.mDesc, true, getResources().getString(2131297067), new IPCallShareCouponCardUI.7(this, paramIntent));
      }
    }
    AppMethodBeat.o(22311);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22298);
    super.onCreate(paramBundle);
    setMMTitle(2131300957);
    setBackBtn(new IPCallShareCouponCardUI.1(this));
    this.jU = findViewById(2131824370);
    this.nVf = ((TextView)findViewById(2131825176));
    this.nVg = ((TextView)findViewById(2131825177));
    this.nVh = ((TextView)findViewById(2131825179));
    this.nVi = ((TextView)findViewById(2131825180));
    this.nVj = ((Button)findViewById(2131825181));
    this.nVk = ((ImageView)findViewById(2131821061));
    this.jU.setVisibility(8);
    com.tencent.mm.pluginsdk.ui.a.b.a(this.nVk, r.Zn(), 0.5F, false);
    paramBundle = getContext();
    getString(2131297087);
    this.nSa = h.b(paramBundle, getString(2131300856), true, new IPCallShareCouponCardUI.9(this));
    com.tencent.mm.plugin.ipcall.a.f.b.bJQ().iJ(false);
    this.mFrom = getIntent().getIntExtra("IPCallShareCouponCardUI_KFrom", 0);
    aw.Rc().a(257, this);
    aw.Rc().a(1804, this);
    AppMethodBeat.o(22298);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22300);
    super.onDestroy();
    aw.Rc().b(257, this);
    aw.Rc().b(1804, this);
    AppMethodBeat.o(22300);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22299);
    super.onResume();
    AppMethodBeat.o(22299);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(22301);
    String str;
    Object localObject1;
    Object localObject2;
    if ((paramm instanceof com.tencent.mm.plugin.ipcall.a.d.g)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.jU.setVisibility(0);
        paramString = com.tencent.mm.plugin.ipcall.b.c.bKP();
        if (paramString != null)
        {
          this.nVr = paramString.xhp;
          this.mDesc = paramString.Desc;
          this.nVs = paramString.xhq;
          this.mTitle = paramString.Title;
          this.mWording = paramString.nQe;
          this.nVt = paramString.xhr;
          this.nVv = paramString.xhs;
          this.nVw = paramString.xht;
          this.nVx = paramString.xhu;
          this.nVy = paramString.xhw;
          this.nVz = paramString.xhv;
          this.nVA = paramString.xhx;
        }
        this.nVf.setText(this.nVy);
        this.nVg.setText(String.format(getContext().getString(2131300950), new Object[] { this.nVr }));
        this.nVj.setOnClickListener(new IPCallShareCouponCardUI.11(this));
        this.nVh.setText(String.format(getString(2131300952), new Object[] { this.nVy }));
        paramm = this.nVi;
        str = String.format(getString(2131300951), new Object[] { this.nVy });
        localObject1 = getString(2131300956);
        if (bo.isNullOrNil((String)localObject1))
        {
          paramm.setText(str);
          if ((this.nSa != null) && (this.nSa.isShowing())) {
            this.nSa.dismiss();
          }
          AppMethodBeat.o(22301);
          return;
        }
        paramString = getString(2131300959);
        localObject2 = paramm.getPaint();
        float f1 = ((TextPaint)localObject2).measureText(str);
        float f2 = ((TextPaint)localObject2).measureText(paramString);
        paramInt1 = com.tencent.mm.cb.a.gw(getContext());
        paramInt2 = ((LinearLayout.LayoutParams)paramm.getLayoutParams()).leftMargin;
        paramInt1 -= ((LinearLayout.LayoutParams)paramm.getLayoutParams()).rightMargin + paramInt2;
        paramInt2 = (int)Math.ceil(f1 / paramInt1);
        int i = (int)Math.ceil((f1 + f2) / paramInt1);
        paramInt1 = paramInt2;
        if (paramInt2 == 0) {
          paramInt1 = 1;
        }
        if (i <= paramInt1) {
          break label743;
        }
        paramString = "\n".concat(String.valueOf(paramString));
      }
    }
    label743:
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
      if ((this.nSa != null) && (this.nSa.isShowing()))
      {
        this.nSa.dismiss();
        h.a(getContext(), getString(2131300854), getString(2131300847), new IPCallShareCouponCardUI.10(this));
        AppMethodBeat.o(22301);
        return;
        if ((paramm instanceof com.tencent.mm.modelmulti.g))
        {
          if (this.eeN != null)
          {
            this.eeN.dismiss();
            this.eeN = null;
          }
          if (com.tencent.mm.plugin.subapp.b.gmP.b(getContext(), paramInt1, paramInt2, paramString))
          {
            AppMethodBeat.o(22301);
            return;
          }
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            h.h(getContext(), 2131303126, 2131297087);
            AppMethodBeat.o(22301);
            return;
          }
          h.bO(this, getResources().getString(2131298502));
          AppMethodBeat.o(22301);
          return;
        }
        if ((paramm instanceof com.tencent.mm.bb.a))
        {
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            AppMethodBeat.o(22301);
            return;
          }
          if (this.nVo != null)
          {
            if (this.nVp != null) {
              this.nVp.setVisibility(8);
            }
            this.nVo.setImageBitmap(bKp());
          }
        }
      }
      AppMethodBeat.o(22301);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI
 * JD-Core Version:    0.7.0.1
 */