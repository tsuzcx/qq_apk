package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
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
import android.text.style.ClickableSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.ipcall.model.f.e;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.applet.y.b;
import com.tencent.mm.protocal.protobuf.blu;
import com.tencent.mm.protocal.protobuf.eci;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.k.a.a;
import com.tencent.mm.ui.k.a.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class IPCallShareCouponCardUI
  extends MMActivity
  implements f, a.a, com.tencent.mm.ui.k.a.b
{
  private ProgressDialog fOC;
  private View mBN;
  private String mDesc;
  private int mFrom;
  private String mTitle;
  private String mWording;
  private ProgressDialog sMH;
  private ProgressDialog vcb;
  private View vfA;
  private TextView vff;
  private TextView vfg;
  private TextView vfh;
  private TextView vfi;
  private Button vfj;
  private ImageView vfk;
  private com.tencent.mm.ui.k.a vfl;
  private i vfm;
  private ImageView vfn;
  private ProgressBar vfo;
  private e vfp;
  private String vfq;
  private String vfr;
  private String vfs;
  private String vft;
  private String vfu;
  private String vfv;
  private String vfw;
  private String vfx;
  private eci vfy;
  private String vfz;
  
  public IPCallShareCouponCardUI()
  {
    AppMethodBeat.i(25917);
    this.vfl = new com.tencent.mm.ui.k.a();
    this.fOC = null;
    this.sMH = null;
    this.vfm = null;
    this.vcb = null;
    this.vfn = null;
    this.vfo = null;
    this.vfp = new e();
    this.vfq = null;
    this.mDesc = null;
    this.vfr = null;
    this.mTitle = null;
    this.mWording = null;
    this.vfs = null;
    this.vft = null;
    this.vfu = null;
    this.vfv = null;
    this.vfw = null;
    this.vfx = null;
    this.vfy = null;
    this.vfz = null;
    this.mFrom = 0;
    AppMethodBeat.o(25917);
  }
  
  private void B(final int paramInt, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(25930);
    this.vfA = View.inflate(getContext(), 2131493586, null);
    final EditText localEditText = (EditText)this.vfA.findViewById(2131298569);
    this.vfn = ((ImageView)this.vfA.findViewById(2131298566));
    this.vfo = ((ProgressBar)this.vfA.findViewById(2131301506));
    localEditText.setText(paramString1);
    Object localObject = dhz();
    if (localObject == null)
    {
      localObject = v.aAC();
      bc.aCg();
      localObject = new com.tencent.mm.bc.a((String)localObject, bu.o((Integer)com.tencent.mm.model.c.ajA().get(66561, null)));
      bc.ajj().a((n)localObject, 0);
      this.vfo.setVisibility(0);
    }
    for (;;)
    {
      o.a(this.mController, paramString2, this.vfA, getResources().getString(2131755884), new y.b()
      {
        public final void nS(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(25906);
          if (paramAnonymousBoolean)
          {
            if (localEditText == null) {}
            for (Object localObject = paramString1;; localObject = localEditText.getText().toString())
            {
              localObject = new com.tencent.mm.modelmulti.h(paramInt, (String)localObject);
              IPCallShareCouponCardUI localIPCallShareCouponCardUI1 = IPCallShareCouponCardUI.this;
              IPCallShareCouponCardUI localIPCallShareCouponCardUI2 = IPCallShareCouponCardUI.this;
              IPCallShareCouponCardUI.this.getString(2131755906);
              IPCallShareCouponCardUI.b(localIPCallShareCouponCardUI1, com.tencent.mm.ui.base.h.b(localIPCallShareCouponCardUI2, IPCallShareCouponCardUI.this.getString(2131755886), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(25905);
                  bc.ajj().a(this.vfE);
                  AppMethodBeat.o(25905);
                }
              }));
              bc.ajj().a((n)localObject, 0);
              AppMethodBeat.o(25906);
              return;
            }
          }
          AppMethodBeat.o(25906);
        }
      });
      AppMethodBeat.o(25930);
      return;
      if (this.vfn != null) {
        this.vfn.setImageBitmap((Bitmap)localObject);
      }
    }
  }
  
  public static int Jk(int paramInt)
  {
    AppMethodBeat.i(25924);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(8), Integer.valueOf(2131689791));
    localHashMap.put(Integer.valueOf(0), Integer.valueOf(2131689838));
    localHashMap.put(Integer.valueOf(1), Integer.valueOf(2131689837));
    localHashMap.put(Integer.valueOf(3), Integer.valueOf(2131689792));
    localHashMap.put(Integer.valueOf(2), Integer.valueOf(2131689839));
    localHashMap.put(Integer.valueOf(5), Integer.valueOf(2131689840));
    localHashMap.put(Integer.valueOf(4), Integer.valueOf(2131689841));
    localHashMap.put(Integer.valueOf(6), Integer.valueOf(2131689793));
    localHashMap.put(Integer.valueOf(7), Integer.valueOf(2131689836));
    if (localHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      paramInt = ((Integer)localHashMap.get(Integer.valueOf(paramInt))).intValue();
      AppMethodBeat.o(25924);
      return paramInt;
    }
    AppMethodBeat.o(25924);
    return -1;
  }
  
  private void Jl(int paramInt)
  {
    AppMethodBeat.i(25927);
    com.tencent.mm.ui.base.h.a(getContext(), paramInt, 2131755906, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(25927);
  }
  
  public static void a(Context paramContext, int paramInt, TextView paramTextView, ImageView paramImageView)
  {
    AppMethodBeat.i(25922);
    paramContext = ad(paramContext, paramInt);
    if (paramContext != null) {
      paramTextView.setText(paramContext);
    }
    paramInt = Jk(paramInt);
    if (paramInt != -1) {
      paramImageView.setImageResource(paramInt);
    }
    AppMethodBeat.o(25922);
  }
  
  public static String ad(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(25923);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(8), paramContext.getString(2131760485));
    localHashMap.put(Integer.valueOf(0), paramContext.getString(2131766188));
    localHashMap.put(Integer.valueOf(1), paramContext.getString(2131760490));
    localHashMap.put(Integer.valueOf(3), paramContext.getString(2131760486));
    localHashMap.put(Integer.valueOf(2), paramContext.getString(2131760489));
    localHashMap.put(Integer.valueOf(5), paramContext.getString(2131760491));
    localHashMap.put(Integer.valueOf(4), paramContext.getString(2131760492));
    localHashMap.put(Integer.valueOf(6), paramContext.getString(2131760488));
    localHashMap.put(Integer.valueOf(7), paramContext.getString(2131760487));
    if (localHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      paramContext = (String)localHashMap.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(25923);
      return paramContext;
    }
    AppMethodBeat.o(25923);
    return null;
  }
  
  /* Error */
  private static byte[] aoU(String paramString)
  {
    // Byte code:
    //   0: sipush 25929
    //   3: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 192	com/tencent/mm/model/bc:aCg	()Lcom/tencent/mm/model/c;
    //   9: pop
    //   10: invokestatic 672	com/tencent/mm/model/c:azQ	()Ljava/lang/String;
    //   13: astore_1
    //   14: invokestatic 192	com/tencent/mm/model/bc:aCg	()Lcom/tencent/mm/model/c;
    //   17: pop
    //   18: aload_1
    //   19: invokestatic 675	com/tencent/mm/model/c:azR	()Ljava/lang/String;
    //   22: ldc_w 677
    //   25: aload_0
    //   26: invokevirtual 681	java/lang/String:getBytes	()[B
    //   29: invokestatic 687	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   32: ldc_w 689
    //   35: invokestatic 695	com/tencent/mm/sdk/platformtools/n:j	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   38: astore_0
    //   39: aload_0
    //   40: invokestatic 699	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   43: ifeq +20 -> 63
    //   46: ldc_w 305
    //   49: ldc_w 701
    //   52: invokestatic 646	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: sipush 25929
    //   58: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: aconst_null
    //   62: areturn
    //   63: aload_0
    //   64: iconst_0
    //   65: invokestatic 707	com/tencent/mm/vfs/o:dg	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   68: astore_1
    //   69: aload_1
    //   70: astore_0
    //   71: aload_1
    //   72: invokevirtual 713	java/io/RandomAccessFile:length	()J
    //   75: l2i
    //   76: newarray byte
    //   78: astore_2
    //   79: aload_1
    //   80: astore_0
    //   81: aload_1
    //   82: aload_2
    //   83: invokevirtual 717	java/io/RandomAccessFile:read	([B)I
    //   86: pop
    //   87: aload_1
    //   88: ifnull +7 -> 95
    //   91: aload_1
    //   92: invokevirtual 720	java/io/RandomAccessFile:close	()V
    //   95: sipush 25929
    //   98: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: aload_2
    //   102: areturn
    //   103: astore_2
    //   104: aconst_null
    //   105: astore_1
    //   106: aload_1
    //   107: astore_0
    //   108: ldc_w 305
    //   111: aload_2
    //   112: ldc_w 508
    //   115: iconst_0
    //   116: anewarray 436	java/lang/Object
    //   119: invokestatic 724	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: aload_1
    //   123: ifnull +7 -> 130
    //   126: aload_1
    //   127: invokevirtual 720	java/io/RandomAccessFile:close	()V
    //   130: sipush 25929
    //   133: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aconst_null
    //   137: areturn
    //   138: astore_1
    //   139: aconst_null
    //   140: astore_0
    //   141: aload_0
    //   142: ifnull +7 -> 149
    //   145: aload_0
    //   146: invokevirtual 720	java/io/RandomAccessFile:close	()V
    //   149: sipush 25929
    //   152: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: aload_1
    //   156: athrow
    //   157: astore_0
    //   158: goto -63 -> 95
    //   161: astore_0
    //   162: goto -32 -> 130
    //   165: astore_0
    //   166: goto -17 -> 149
    //   169: astore_1
    //   170: goto -29 -> 141
    //   173: astore_2
    //   174: goto -68 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramString	String
    //   13	114	1	localObject1	Object
    //   138	18	1	localObject2	Object
    //   169	1	1	localObject3	Object
    //   78	24	2	arrayOfByte	byte[]
    //   103	9	2	localException1	java.lang.Exception
    //   173	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   63	69	103	java/lang/Exception
    //   63	69	138	finally
    //   91	95	157	java/lang/Exception
    //   126	130	161	java/lang/Exception
    //   145	149	165	java/lang/Exception
    //   71	79	169	finally
    //   81	87	169	finally
    //   108	122	169	finally
    //   71	79	173	java/lang/Exception
    //   81	87	173	java/lang/Exception
  }
  
  private static boolean checkApkExist(Context paramContext, String paramString)
  {
    AppMethodBeat.i(25925);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(25925);
      return false;
    }
    try
    {
      paramContext.getPackageManager().getApplicationInfo(paramString, 8192);
      AppMethodBeat.o(25925);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(25925);
    }
    return false;
  }
  
  private static Bitmap dhz()
  {
    AppMethodBeat.i(25928);
    Object localObject = aoU(v.aAC());
    if (localObject == null)
    {
      AppMethodBeat.o(25928);
      return null;
    }
    localObject = com.tencent.mm.sdk.platformtools.h.cu((byte[])localObject);
    AppMethodBeat.o(25928);
    return localObject;
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(25926);
    if (this.sMH != null) {
      this.sMH.cancel();
    }
    switch (IPCallShareCouponCardUI.8.vfI[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25926);
      return;
      Jl(2131764543);
      AppMethodBeat.o(25926);
      return;
      AppMethodBeat.o(25926);
      return;
      Jl(2131764542);
    }
  }
  
  public final void b(a.c paramc) {}
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494504;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(25931);
    if ((paramInt1 == 1) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      if (!bu.isNullOrNil(paramIntent)) {
        o.a(getController(), this.mTitle, this.vfr, this.mDesc, true, getResources().getString(2131755884), new y.a()
        {
          public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
          {
            AppMethodBeat.i(25909);
            if (paramAnonymousBoolean)
            {
              Object localObject = new k.b();
              ((k.b)localObject).title = IPCallShareCouponCardUI.d(IPCallShareCouponCardUI.this);
              ((k.b)localObject).url = IPCallShareCouponCardUI.e(IPCallShareCouponCardUI.this);
              ((k.b)localObject).description = IPCallShareCouponCardUI.f(IPCallShareCouponCardUI.this);
              ((k.b)localObject).thumburl = IPCallShareCouponCardUI.g(IPCallShareCouponCardUI.this);
              ((k.b)localObject).type = 5;
              m.a((k.b)localObject, null, null, paramIntent, "", null, null);
              if (!bu.isNullOrNil(paramAnonymousString))
              {
                localObject = new sy();
                ((sy)localObject).dID.cUB = paramIntent;
                ((sy)localObject).dID.content = paramAnonymousString;
                ((sy)localObject).dID.type = x.Bb(paramIntent);
                ((sy)localObject).dID.flags = 0;
                com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
              }
              com.tencent.mm.ui.base.h.cm(IPCallShareCouponCardUI.this.getContext(), IPCallShareCouponCardUI.this.getResources().getString(2131755894));
              AppMethodBeat.o(25909);
              return;
            }
            AppMethodBeat.o(25909);
          }
        });
      }
    }
    AppMethodBeat.o(25931);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25918);
    super.onCreate(paramBundle);
    setMMTitle(2131760558);
    setBackBtn(new IPCallShareCouponCardUI.1(this));
    this.mBN = findViewById(2131301339);
    this.vff = ((TextView)findViewById(2131298810));
    this.vfg = ((TextView)findViewById(2131298927));
    this.vfh = ((TextView)findViewById(2131298809));
    this.vfi = ((TextView)findViewById(2131298811));
    this.vfj = ((Button)findViewById(2131304737));
    this.vfk = ((ImageView)findViewById(2131300718));
    this.mBN.setVisibility(8);
    com.tencent.mm.pluginsdk.ui.a.b.a(this.vfk, v.aAC(), 0.5F, false);
    paramBundle = getContext();
    getString(2131755906);
    this.vcb = com.tencent.mm.ui.base.h.b(paramBundle, getString(2131760457), true, new IPCallShareCouponCardUI.9(this));
    com.tencent.mm.plugin.ipcall.model.g.b.dha().nP(false);
    this.mFrom = getIntent().getIntExtra("IPCallShareCouponCardUI_KFrom", 0);
    bc.ajj().a(257, this);
    bc.ajj().a(1804, this);
    AppMethodBeat.o(25918);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25920);
    super.onDestroy();
    bc.ajj().b(257, this);
    bc.ajj().b(1804, this);
    AppMethodBeat.o(25920);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25919);
    super.onResume();
    AppMethodBeat.o(25919);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(25921);
    String str;
    Object localObject1;
    Object localObject2;
    if ((paramn instanceof com.tencent.mm.plugin.ipcall.model.e.g)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.mBN.setVisibility(0);
        paramString = com.tencent.mm.plugin.ipcall.a.c.dia();
        if (paramString != null)
        {
          this.vfq = paramString.GYO;
          this.mDesc = paramString.Desc;
          this.vfr = paramString.GYP;
          this.mTitle = paramString.Title;
          this.mWording = paramString.urq;
          this.vfs = paramString.GYQ;
          this.vfu = paramString.GYR;
          this.vfv = paramString.GYS;
          this.vfw = paramString.GYT;
          this.vfx = paramString.GYV;
          this.vfy = paramString.GYU;
          this.vfz = paramString.GYW;
        }
        this.vff.setText(this.vfx);
        this.vfg.setText(String.format(getContext().getString(2131760551), new Object[] { this.vfq }));
        this.vfj.setOnClickListener(new IPCallShareCouponCardUI.11(this));
        this.vfh.setText(String.format(getString(2131760553), new Object[] { this.vfx }));
        paramn = this.vfi;
        str = String.format(getString(2131760552), new Object[] { this.vfx });
        localObject1 = getString(2131760557);
        if (bu.isNullOrNil((String)localObject1))
        {
          paramn.setText(str);
          if ((this.vcb != null) && (this.vcb.isShowing())) {
            this.vcb.dismiss();
          }
          AppMethodBeat.o(25921);
          return;
        }
        paramString = getString(2131760560);
        localObject2 = paramn.getPaint();
        float f1 = ((TextPaint)localObject2).measureText(str);
        float f2 = ((TextPaint)localObject2).measureText(paramString);
        paramInt1 = com.tencent.mm.cb.a.iu(getContext());
        paramInt2 = ((LinearLayout.LayoutParams)paramn.getLayoutParams()).leftMargin;
        paramInt1 -= ((LinearLayout.LayoutParams)paramn.getLayoutParams()).rightMargin + paramInt2;
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
      paramn.setGravity(17);
      localObject2 = Spannable.Factory.getInstance().newSpannable(str + paramString);
      localObject1 = new ClickableSpan()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25907);
          ((TextView)paramAnonymousView).setHighlightColor(IPCallShareCouponCardUI.this.getResources().getColor(2131101053));
          com.tencent.mm.plugin.report.service.g.yxI.f(13340, new Object[] { Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(1) });
          com.tencent.mm.ui.base.h.c(IPCallShareCouponCardUI.this.getContext(), this.vfG, IPCallShareCouponCardUI.this.getString(2131760561), true).a(2131760433, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          });
          AppMethodBeat.o(25907);
        }
        
        public final void updateDrawState(TextPaint paramAnonymousTextPaint)
        {
          AppMethodBeat.i(25908);
          paramAnonymousTextPaint.setColor(IPCallShareCouponCardUI.this.getResources().getColor(2131100547));
          paramAnonymousTextPaint.setUnderlineText(false);
          AppMethodBeat.o(25908);
        }
      };
      paramInt1 = str.length();
      paramInt2 = str.length();
      ((Spannable)localObject2).setSpan(localObject1, paramInt1, paramString.length() + paramInt2, 33);
      paramn.setText((CharSequence)localObject2);
      paramn.setMovementMethod(LinkMovementMethod.getInstance());
      break;
      if ((this.vcb != null) && (this.vcb.isShowing()))
      {
        this.vcb.dismiss();
        com.tencent.mm.ui.base.h.d(getContext(), getString(2131760455), getString(2131760448), new IPCallShareCouponCardUI.10(this));
        AppMethodBeat.o(25921);
        return;
        if ((paramn instanceof com.tencent.mm.modelmulti.h))
        {
          if (this.fOC != null)
          {
            this.fOC.dismiss();
            this.fOC = null;
          }
          if (com.tencent.mm.plugin.subapp.b.iUA.b(getContext(), paramInt1, paramInt2, paramString))
          {
            AppMethodBeat.o(25921);
            return;
          }
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            com.tencent.mm.ui.base.h.l(getContext(), 2131763075, 2131755906);
            AppMethodBeat.o(25921);
            return;
          }
          com.tencent.mm.ui.base.h.cm(this, getResources().getString(2131757561));
          AppMethodBeat.o(25921);
          return;
        }
        if ((paramn instanceof com.tencent.mm.bc.a))
        {
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            AppMethodBeat.o(25921);
            return;
          }
          if (this.vfn != null)
          {
            if (this.vfo != null) {
              this.vfo.setVisibility(8);
            }
            this.vfn.setImageBitmap(dhz());
          }
        }
      }
      AppMethodBeat.o(25921);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI
 * JD-Core Version:    0.7.0.1
 */