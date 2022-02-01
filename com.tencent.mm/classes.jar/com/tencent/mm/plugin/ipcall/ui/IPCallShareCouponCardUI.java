package com.tencent.mm.plugin.ipcall.ui;

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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.wp;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.m;
import com.tencent.mm.plugin.ipcall.model.e.g;
import com.tencent.mm.plugin.ipcall.model.g.b;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.applet.y.b;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.protocal.protobuf.gdn;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.q.a.a;
import com.tencent.mm.ui.q.a.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class IPCallShareCouponCardUI
  extends MMActivity
  implements com.tencent.mm.am.h, a.a, com.tencent.mm.ui.q.a.b
{
  private ProgressDialog FPA;
  private TextView JOR;
  private TextView JOS;
  private TextView JOT;
  private TextView JOU;
  private Button JOV;
  private ImageView JOW;
  private com.tencent.mm.ui.q.a JOX;
  private ImageView JOY;
  private ProgressBar JOZ;
  private com.tencent.mm.plugin.ipcall.model.f.e JPa;
  private String JPb;
  private String JPc;
  private String JPd;
  private String JPe;
  private String JPf;
  private String JPg;
  private String JPh;
  private String JPi;
  private gdn JPj;
  private String JPk;
  private View JPl;
  private ProgressDialog lzP;
  private String mDesc;
  private int mFrom;
  private String mTitle;
  private String mWording;
  private View tUE;
  private ProgressDialog xZJ;
  
  public IPCallShareCouponCardUI()
  {
    AppMethodBeat.i(25917);
    this.JOX = new com.tencent.mm.ui.q.a();
    this.lzP = null;
    this.FPA = null;
    this.xZJ = null;
    this.JOY = null;
    this.JOZ = null;
    this.JPa = new com.tencent.mm.plugin.ipcall.model.f.e();
    this.JPb = null;
    this.mDesc = null;
    this.JPc = null;
    this.mTitle = null;
    this.mWording = null;
    this.JPd = null;
    this.JPe = null;
    this.JPf = null;
    this.JPg = null;
    this.JPh = null;
    this.JPi = null;
    this.JPj = null;
    this.JPk = null;
    this.mFrom = 0;
    AppMethodBeat.o(25917);
  }
  
  private void L(final int paramInt, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(25930);
    this.JPl = View.inflate(getContext(), R.i.confirm_dialog_item, null);
    final EditText localEditText = (EditText)this.JPl.findViewById(R.h.confirm_dialog_text_et);
    this.JOY = ((ImageView)this.JPl.findViewById(R.h.confirm_dialog_imageview));
    this.JOZ = ((ProgressBar)this.JPl.findViewById(R.h.loading_pb));
    localEditText.setText(paramString1);
    Object localObject = fSr();
    if (localObject == null)
    {
      localObject = z.bAM();
      bh.bCz();
      localObject = new com.tencent.mm.az.a((String)localObject, Util.nullAsNil((Integer)com.tencent.mm.model.c.ban().d(66561, null)));
      bh.aZW().a((p)localObject, 0);
      this.JOZ.setVisibility(0);
    }
    for (;;)
    {
      o.a(this.mController, paramString2, this.JPl, getResources().getString(R.l.app_send), new y.b()
      {
        public final void onDialogClick(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(25906);
          if (paramAnonymousBoolean)
          {
            if (localEditText == null) {}
            for (Object localObject = paramString1;; localObject = localEditText.getText().toString())
            {
              localObject = new m(paramInt, (String)localObject);
              IPCallShareCouponCardUI localIPCallShareCouponCardUI1 = IPCallShareCouponCardUI.this;
              IPCallShareCouponCardUI localIPCallShareCouponCardUI2 = IPCallShareCouponCardUI.this;
              IPCallShareCouponCardUI.this.getString(R.l.app_tip);
              IPCallShareCouponCardUI.b(localIPCallShareCouponCardUI1, k.a(localIPCallShareCouponCardUI2, IPCallShareCouponCardUI.this.getString(R.l.app_sending), true, new DialogInterface.OnCancelListener()
              {
                public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(25905);
                  bh.aZW().a(this.JPp);
                  AppMethodBeat.o(25905);
                }
              }));
              bh.aZW().a((p)localObject, 0);
              AppMethodBeat.o(25906);
              return;
            }
          }
          AppMethodBeat.o(25906);
        }
      });
      AppMethodBeat.o(25930);
      return;
      if (this.JOY != null) {
        this.JOY.setImageBitmap((Bitmap)localObject);
      }
    }
  }
  
  public static int Zr(int paramInt)
  {
    AppMethodBeat.i(25924);
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
    if (localHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      paramInt = ((Integer)localHashMap.get(Integer.valueOf(paramInt))).intValue();
      AppMethodBeat.o(25924);
      return paramInt;
    }
    AppMethodBeat.o(25924);
    return -1;
  }
  
  private void Zs(int paramInt)
  {
    AppMethodBeat.i(25927);
    k.a(getContext(), paramInt, R.l.app_tip, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(25927);
  }
  
  /* Error */
  private static byte[] aJp(String paramString)
  {
    // Byte code:
    //   0: sipush 25929
    //   3: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 200	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   9: pop
    //   10: invokestatic 700	com/tencent/mm/model/c:bzL	()Ljava/lang/String;
    //   13: astore_1
    //   14: invokestatic 200	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   17: pop
    //   18: aload_1
    //   19: invokestatic 703	com/tencent/mm/model/c:bzM	()Ljava/lang/String;
    //   22: ldc_w 705
    //   25: aload_0
    //   26: invokevirtual 709	java/lang/String:getBytes	()[B
    //   29: invokestatic 715	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   32: ldc_w 717
    //   35: iconst_1
    //   36: invokestatic 723	com/tencent/mm/sdk/platformtools/FilePathGenerator:defGenPathWithOld	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   39: astore_0
    //   40: aload_0
    //   41: invokestatic 727	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   44: ifeq +20 -> 64
    //   47: ldc_w 341
    //   50: ldc_w 729
    //   53: invokestatic 682	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: sipush 25929
    //   59: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aconst_null
    //   63: areturn
    //   64: aload_0
    //   65: iconst_0
    //   66: invokestatic 735	com/tencent/mm/vfs/y:eA	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   69: astore_1
    //   70: aload_1
    //   71: astore_0
    //   72: aload_1
    //   73: invokevirtual 741	java/io/RandomAccessFile:length	()J
    //   76: l2i
    //   77: newarray byte
    //   79: astore_2
    //   80: aload_1
    //   81: astore_0
    //   82: aload_1
    //   83: aload_2
    //   84: invokevirtual 745	java/io/RandomAccessFile:read	([B)I
    //   87: pop
    //   88: aload_1
    //   89: ifnull +7 -> 96
    //   92: aload_1
    //   93: invokevirtual 748	java/io/RandomAccessFile:close	()V
    //   96: sipush 25929
    //   99: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_2
    //   103: areturn
    //   104: astore_2
    //   105: aconst_null
    //   106: astore_1
    //   107: aload_1
    //   108: astore_0
    //   109: ldc_w 341
    //   112: aload_2
    //   113: ldc_w 534
    //   116: iconst_0
    //   117: anewarray 461	java/lang/Object
    //   120: invokestatic 752	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   123: aload_1
    //   124: ifnull +7 -> 131
    //   127: aload_1
    //   128: invokevirtual 748	java/io/RandomAccessFile:close	()V
    //   131: sipush 25929
    //   134: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: aconst_null
    //   138: areturn
    //   139: astore_1
    //   140: aconst_null
    //   141: astore_0
    //   142: aload_0
    //   143: ifnull +7 -> 150
    //   146: aload_0
    //   147: invokevirtual 748	java/io/RandomAccessFile:close	()V
    //   150: sipush 25929
    //   153: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: aload_1
    //   157: athrow
    //   158: astore_0
    //   159: goto -63 -> 96
    //   162: astore_0
    //   163: goto -32 -> 131
    //   166: astore_0
    //   167: goto -17 -> 150
    //   170: astore_1
    //   171: goto -29 -> 142
    //   174: astore_2
    //   175: goto -68 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	paramString	String
    //   13	115	1	localObject1	Object
    //   139	18	1	localObject2	Object
    //   170	1	1	localObject3	Object
    //   79	24	2	arrayOfByte	byte[]
    //   104	9	2	localException1	java.lang.Exception
    //   174	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   64	70	104	java/lang/Exception
    //   64	70	139	finally
    //   92	96	158	java/lang/Exception
    //   127	131	162	java/lang/Exception
    //   146	150	166	java/lang/Exception
    //   72	80	170	finally
    //   82	88	170	finally
    //   109	123	170	finally
    //   72	80	174	java/lang/Exception
    //   82	88	174	java/lang/Exception
  }
  
  public static String aO(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(25923);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(8), paramContext.getString(R.l.gKP));
    localHashMap.put(Integer.valueOf(0), paramContext.getString(R.l.gYZ));
    localHashMap.put(Integer.valueOf(1), paramContext.getString(R.l.gKU));
    localHashMap.put(Integer.valueOf(3), paramContext.getString(R.l.gKQ));
    localHashMap.put(Integer.valueOf(2), paramContext.getString(R.l.gKT));
    localHashMap.put(Integer.valueOf(5), paramContext.getString(R.l.gKV));
    localHashMap.put(Integer.valueOf(4), paramContext.getString(R.l.gKW));
    localHashMap.put(Integer.valueOf(6), paramContext.getString(R.l.gKS));
    localHashMap.put(Integer.valueOf(7), paramContext.getString(R.l.gKR));
    if (localHashMap.containsKey(Integer.valueOf(paramInt)))
    {
      paramContext = (String)localHashMap.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(25923);
      return paramContext;
    }
    AppMethodBeat.o(25923);
    return null;
  }
  
  private static boolean checkApkExist(Context paramContext, String paramString)
  {
    AppMethodBeat.i(25925);
    if (Util.isNullOrNil(paramString))
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
  
  private static Bitmap fSr()
  {
    AppMethodBeat.i(25928);
    Object localObject = aJp(z.bAM());
    if (localObject == null)
    {
      AppMethodBeat.o(25928);
      return null;
    }
    localObject = BitmapUtil.decodeByteArray((byte[])localObject);
    AppMethodBeat.o(25928);
    return localObject;
  }
  
  public final void a(a.c paramc)
  {
    AppMethodBeat.i(25926);
    if (this.FPA != null) {
      this.FPA.cancel();
    }
    switch (IPCallShareCouponCardUI.8.JPt[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25926);
      return;
      Zs(R.l.twitterlogin_success);
      AppMethodBeat.o(25926);
      return;
      AppMethodBeat.o(25926);
      return;
      Zs(R.l.twitterlogin_failed);
    }
  }
  
  public final void b(a.c paramc) {}
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return R.i.gkK;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(25931);
    if ((paramInt1 == 1) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      if (!Util.isNullOrNil(paramIntent)) {
        o.a(getController(), this.mTitle, this.JPc, this.mDesc, true, getResources().getString(R.l.app_send), new y.a()
        {
          public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
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
              n.a((k.b)localObject, null, null, paramIntent, "", null, null);
              if (!Util.isNullOrNil(paramAnonymousString))
              {
                localObject = new wp();
                ((wp)localObject).iak.hgl = paramIntent;
                ((wp)localObject).iak.content = paramAnonymousString;
                ((wp)localObject).iak.type = ab.IX(paramIntent);
                ((wp)localObject).iak.flags = 0;
                ((wp)localObject).publish();
              }
              k.cZ(IPCallShareCouponCardUI.this.getContext(), IPCallShareCouponCardUI.this.getResources().getString(R.l.app_shared));
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
    setMMTitle(R.l.gLP);
    setBackBtn(new IPCallShareCouponCardUI.1(this));
    this.tUE = findViewById(R.h.layout);
    this.JOR = ((TextView)findViewById(R.h.fDJ));
    this.JOS = ((TextView)findViewById(R.h.fEt));
    this.JOT = ((TextView)findViewById(R.h.fDI));
    this.JOU = ((TextView)findViewById(R.h.fDK));
    this.JOV = ((Button)findViewById(R.h.fXu));
    this.JOW = ((ImageView)findViewById(R.h.header_icon));
    this.tUE.setVisibility(8);
    com.tencent.mm.pluginsdk.ui.a.b.a(this.JOW, z.bAM(), 0.5F, false);
    paramBundle = getContext();
    getString(R.l.app_tip);
    this.xZJ = k.a(paramBundle, getString(R.l.gKx), true, new IPCallShareCouponCardUI.9(this));
    b.fRS().xL(false);
    this.mFrom = getIntent().getIntExtra("IPCallShareCouponCardUI_KFrom", 0);
    bh.aZW().a(257, this);
    bh.aZW().a(1804, this);
    AppMethodBeat.o(25918);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(25920);
    super.onDestroy();
    bh.aZW().b(257, this);
    bh.aZW().b(1804, this);
    AppMethodBeat.o(25920);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(25919);
    super.onResume();
    AppMethodBeat.o(25919);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(25921);
    String str;
    Object localObject1;
    Object localObject2;
    if ((paramp instanceof g)) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.tUE.setVisibility(0);
        paramString = com.tencent.mm.plugin.ipcall.a.c.fSO();
        if (paramString != null)
        {
          this.JPb = paramString.aaBn;
          this.mDesc = paramString.IGG;
          this.JPc = paramString.aaBo;
          this.mTitle = paramString.hAP;
          this.mWording = paramString.IHZ;
          this.JPd = paramString.aaBp;
          this.JPf = paramString.aaBq;
          this.JPg = paramString.aaBr;
          this.JPh = paramString.aaBs;
          this.JPi = paramString.aaBu;
          this.JPj = paramString.aaBt;
          this.JPk = paramString.aaBv;
        }
        this.JOR.setText(this.JPi);
        this.JOS.setText(String.format(getContext().getString(R.l.gLK), new Object[] { this.JPb }));
        this.JOV.setOnClickListener(new IPCallShareCouponCardUI.11(this));
        this.JOT.setText(String.format(getString(R.l.gLM), new Object[] { this.JPi }));
        paramp = this.JOU;
        str = String.format(getString(R.l.gLL), new Object[] { this.JPi });
        localObject1 = getString(R.l.gLO);
        if (Util.isNullOrNil((String)localObject1))
        {
          paramp.setText(str);
          if ((this.xZJ != null) && (this.xZJ.isShowing())) {
            this.xZJ.dismiss();
          }
          AppMethodBeat.o(25921);
          return;
        }
        paramString = getString(R.l.gLQ);
        localObject2 = paramp.getPaint();
        float f1 = ((TextPaint)localObject2).measureText(str);
        float f2 = ((TextPaint)localObject2).measureText(paramString);
        paramInt1 = com.tencent.mm.cd.a.ms(getContext());
        paramInt2 = ((LinearLayout.LayoutParams)paramp.getLayoutParams()).leftMargin;
        paramInt1 -= ((LinearLayout.LayoutParams)paramp.getLayoutParams()).rightMargin + paramInt2;
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
      paramp.setGravity(17);
      localObject2 = Spannable.Factory.getInstance().newSpannable(str + paramString);
      localObject1 = new ClickableSpan()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25907);
          ((TextView)paramAnonymousView).setHighlightColor(IPCallShareCouponCardUI.this.getResources().getColor(R.e.transparent));
          com.tencent.mm.plugin.report.service.h.OAn.b(13340, new Object[] { Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(1) });
          k.c(IPCallShareCouponCardUI.this.getContext(), this.JPr, IPCallShareCouponCardUI.this.getString(R.l.gLR), true).a(R.l.gKi, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          });
          AppMethodBeat.o(25907);
        }
        
        public final void updateDrawState(TextPaint paramAnonymousTextPaint)
        {
          AppMethodBeat.i(25908);
          paramAnonymousTextPaint.setColor(IPCallShareCouponCardUI.this.getResources().getColor(R.e.link_color));
          paramAnonymousTextPaint.setUnderlineText(false);
          AppMethodBeat.o(25908);
        }
      };
      paramInt1 = str.length();
      paramInt2 = str.length();
      ((Spannable)localObject2).setSpan(localObject1, paramInt1, paramString.length() + paramInt2, 33);
      paramp.setText((CharSequence)localObject2);
      paramp.setMovementMethod(LinkMovementMethod.getInstance());
      break;
      if ((this.xZJ != null) && (this.xZJ.isShowing()))
      {
        this.xZJ.dismiss();
        k.d(getContext(), getString(R.l.gKv), getString(R.l.ip_call_func_name), new IPCallShareCouponCardUI.10(this));
        AppMethodBeat.o(25921);
        return;
        if ((paramp instanceof m))
        {
          if (this.lzP != null)
          {
            this.lzP.dismiss();
            this.lzP = null;
          }
          if (com.tencent.mm.plugin.subapp.a.pFo.b(getContext(), paramInt1, paramInt2, paramString))
          {
            AppMethodBeat.o(25921);
            return;
          }
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            k.s(getContext(), R.l.sendrequest_send_fail, R.l.app_tip);
            AppMethodBeat.o(25921);
            return;
          }
          k.cZ(this, getResources().getString(R.l.confirm_dialog_sent));
          AppMethodBeat.o(25921);
          return;
        }
        if ((paramp instanceof com.tencent.mm.az.a))
        {
          if ((paramInt1 != 0) || (paramInt2 != 0))
          {
            AppMethodBeat.o(25921);
            return;
          }
          if (this.JOY != null)
          {
            if (this.JOZ != null) {
              this.JOZ.setVisibility(8);
            }
            this.JOY.setImageBitmap(fSr());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI
 * JD-Core Version:    0.7.0.1
 */