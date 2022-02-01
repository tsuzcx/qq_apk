package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.ipcall.model.f.e;
import com.tencent.mm.plugin.ipcall.model.h.m;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.e.c;
import java.util.ArrayList;
import java.util.LinkedList;

public class IPCallUserProfileUI
  extends MMActivity
{
  private String dIm;
  private String dKb;
  private ImageView fRd;
  private boolean uQk;
  private TextView uUN;
  private TextView uUO;
  private LinearLayout uUP;
  private LinearLayout uUQ;
  private TextView uUR;
  private TextView uUS;
  private TextView uUT;
  private TextView uUU;
  private TextView uUV;
  private Button uUW;
  private String uUX;
  private String uUY;
  private Bitmap uUZ;
  private boolean uVa;
  private Cursor uVb;
  private boolean uVc;
  private e uVd;
  
  public IPCallUserProfileUI()
  {
    AppMethodBeat.i(26007);
    this.uQk = false;
    this.uVb = null;
    this.uVc = false;
    this.uVd = new e();
    AppMethodBeat.o(26007);
  }
  
  private void a(com.tencent.mm.plugin.ipcall.model.h.k paramk, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(26014);
    View localView = LayoutInflater.from(this).inflate(2131495145, this.uUQ, false);
    TextView localTextView1 = (TextView)localView.findViewById(2131303486);
    TextView localTextView2 = (TextView)localView.findViewById(2131303488);
    TextView localTextView3 = (TextView)localView.findViewById(2131303489);
    localTextView2.setText(com.tencent.mm.plugin.ipcall.a.a.aof(paramk.field_phonenumber));
    if (paramk.field_duration > 0L) {
      localTextView3.setText(com.tencent.mm.plugin.ipcall.a.c.xV(paramk.field_duration));
    }
    for (;;)
    {
      localTextView1.setText(com.tencent.mm.plugin.ipcall.a.c.xR(paramk.field_calltime));
      if (paramBoolean)
      {
        localView.setBackgroundDrawable(getResources().getDrawable(2131233672));
        int i = getResources().getDimensionPixelSize(2131166702);
        localView.setPadding(i, 0, i, 0);
      }
      if (1 == paramInt)
      {
        paramk = (LinearLayout.LayoutParams)localView.getLayoutParams();
        paramk.height = com.tencent.mm.cc.a.ax(getContext(), 2131166673);
        localView.setLayoutParams(paramk);
      }
      this.uUQ.addView(localView);
      AppMethodBeat.o(26014);
      return;
      localTextView3.setText(com.tencent.mm.plugin.ipcall.a.c.IQ(paramk.field_status));
    }
  }
  
  /* Error */
  private static String anT(String paramString)
  {
    // Byte code:
    //   0: sipush 26011
    //   3: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 300	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   9: ldc_w 302
    //   12: invokestatic 308	com/tencent/mm/pluginsdk/permission/b:n	(Landroid/content/Context;Ljava/lang/String;)Z
    //   15: ifne +20 -> 35
    //   18: ldc_w 310
    //   21: ldc_w 312
    //   24: invokestatic 318	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: sipush 26011
    //   30: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aconst_null
    //   34: areturn
    //   35: invokestatic 300	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   38: invokevirtual 324	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   41: getstatic 330	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   44: aconst_null
    //   45: ldc_w 332
    //   48: iconst_1
    //   49: anewarray 334	java/lang/String
    //   52: dup
    //   53: iconst_0
    //   54: aload_0
    //   55: aastore
    //   56: aconst_null
    //   57: invokevirtual 340	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   60: astore 4
    //   62: aload 4
    //   64: ifnonnull +11 -> 75
    //   67: sipush 26011
    //   70: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aconst_null
    //   74: areturn
    //   75: aload 4
    //   77: invokeinterface 346 1 0
    //   82: istore_1
    //   83: iload_1
    //   84: ifeq +152 -> 236
    //   87: ldc_w 348
    //   90: astore_0
    //   91: aload_0
    //   92: astore_2
    //   93: aload_0
    //   94: astore_3
    //   95: aload 4
    //   97: invokeinterface 351 1 0
    //   102: ifne +138 -> 240
    //   105: aload_0
    //   106: astore_2
    //   107: aload 4
    //   109: aload 4
    //   111: ldc_w 353
    //   114: invokeinterface 357 2 0
    //   119: invokeinterface 360 2 0
    //   124: astore_3
    //   125: aload_0
    //   126: astore_2
    //   127: new 362	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 363	java/lang/StringBuilder:<init>	()V
    //   134: aload_0
    //   135: invokevirtual 367	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_3
    //   139: invokevirtual 367	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc_w 369
    //   145: invokevirtual 367	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 373	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: astore_0
    //   152: aload_0
    //   153: astore_2
    //   154: aload 4
    //   156: invokeinterface 376 1 0
    //   161: pop
    //   162: goto -71 -> 91
    //   165: astore_0
    //   166: ldc_w 310
    //   169: ldc_w 378
    //   172: iconst_2
    //   173: anewarray 256	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: aload_0
    //   179: invokevirtual 381	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   182: aastore
    //   183: dup
    //   184: iconst_1
    //   185: aload_0
    //   186: invokevirtual 385	java/lang/Object:getClass	()Ljava/lang/Class;
    //   189: invokevirtual 390	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   192: aastore
    //   193: invokestatic 393	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: aload 4
    //   198: invokeinterface 396 1 0
    //   203: aload_2
    //   204: astore_0
    //   205: aload_2
    //   206: ldc_w 369
    //   209: invokevirtual 399	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   212: iflt +16 -> 228
    //   215: aload_2
    //   216: iconst_0
    //   217: aload_2
    //   218: ldc_w 369
    //   221: invokevirtual 399	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   224: invokevirtual 403	java/lang/String:substring	(II)Ljava/lang/String;
    //   227: astore_0
    //   228: sipush 26011
    //   231: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   234: aload_0
    //   235: areturn
    //   236: ldc_w 348
    //   239: astore_3
    //   240: aload 4
    //   242: invokeinterface 396 1 0
    //   247: aload_3
    //   248: astore_2
    //   249: goto -46 -> 203
    //   252: astore_0
    //   253: aload 4
    //   255: invokeinterface 396 1 0
    //   260: sipush 26011
    //   263: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: aload_0
    //   267: athrow
    //   268: astore_0
    //   269: ldc_w 348
    //   272: astore_2
    //   273: goto -107 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	paramString	String
    //   82	2	1	bool	boolean
    //   92	181	2	localObject	Object
    //   94	154	3	str	String
    //   60	194	4	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   95	105	165	java/lang/Exception
    //   107	125	165	java/lang/Exception
    //   127	152	165	java/lang/Exception
    //   154	162	165	java/lang/Exception
    //   75	83	252	finally
    //   95	105	252	finally
    //   107	125	252	finally
    //   127	152	252	finally
    //   154	162	252	finally
    //   166	196	252	finally
    //   75	83	268	java/lang/Exception
  }
  
  private void deJ()
  {
    int i = 0;
    AppMethodBeat.i(26009);
    ArrayList localArrayList = new ArrayList();
    if ((this.uVb != null) && (this.uVb.getCount() > 0))
    {
      for (;;)
      {
        try
        {
          if ((!this.uVb.moveToFirst()) || (this.uVb.isAfterLast())) {
            break label224;
          }
          i += 1;
          str = this.uVb.getString(this.uVb.getColumnIndex("data1"));
          j = this.uVb.getInt(this.uVb.getColumnIndex("data2"));
          if (!localArrayList.contains(str))
          {
            localArrayList.add(str);
            if (i != this.uVb.getCount()) {
              continue;
            }
            o(str, j, false);
          }
        }
        catch (Exception localException)
        {
          String str;
          int j;
          ad.e("MicroMsg.IPCallUserProfileUI", "initPhoneNumberList error: %s", new Object[] { localException.getMessage() });
          return;
          o(str, j, true);
          continue;
        }
        finally
        {
          this.uVb.close();
          AppMethodBeat.o(26009);
        }
        this.uVb.moveToNext();
      }
      label224:
      this.uVb.close();
      AppMethodBeat.o(26009);
      return;
    }
    this.uUP.setVisibility(8);
    AppMethodBeat.o(26009);
  }
  
  private void deK()
  {
    AppMethodBeat.i(26012);
    this.uUW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(26004);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        IPCallUserProfileUI.d(IPCallUserProfileUI.this).start();
        IPCallUserProfileUI.d(IPCallUserProfileUI.this).uNK = 1L;
        IPCallUserProfileUI.d(IPCallUserProfileUI.this).uNL = 5L;
        IPCallUserProfileUI.d(IPCallUserProfileUI.this).finish();
        com.tencent.mm.plugin.report.service.g.yhR.f(12766, new Object[] { Integer.valueOf(3) });
        if (!bt.isNullOrNil(IPCallUserProfileUI.e(IPCallUserProfileUI.this)))
        {
          localObject = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + IPCallUserProfileUI.anU(IPCallUserProfileUI.e(IPCallUserProfileUI.this))));
          ((Intent)localObject).putExtra("sms_body", IPCallUserProfileUI.this.getString(2131760453, new Object[] { u.aAY().adu() }));
          paramAnonymousView = IPCallUserProfileUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(26004);
          return;
          if (!bt.isNullOrNil(IPCallUserProfileUI.f(IPCallUserProfileUI.this)))
          {
            localObject = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + IPCallUserProfileUI.f(IPCallUserProfileUI.this)));
            ((Intent)localObject).putExtra("sms_body", IPCallUserProfileUI.this.getString(2131760453, new Object[] { u.aAY().adu() }));
            paramAnonymousView = IPCallUserProfileUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
      }
    });
    AppMethodBeat.o(26012);
  }
  
  private void deL()
  {
    AppMethodBeat.i(26013);
    if (!this.uVc)
    {
      this.uUQ.setVisibility(8);
      this.uUU.setVisibility(8);
    }
    Cursor localCursor;
    if (!bt.isNullOrNil(this.dKb))
    {
      localCursor = m.anF(this.dKb);
      if ((localCursor == null) || (localCursor.getCount() <= 0)) {
        break label262;
      }
    }
    for (;;)
    {
      try
      {
        if (localCursor.moveToFirst())
        {
          int i = 0;
          j = i;
          if (!localCursor.isAfterLast())
          {
            com.tencent.mm.plugin.ipcall.model.h.k localk = new com.tencent.mm.plugin.ipcall.model.h.k();
            localk.convertFrom(localCursor);
            i += 1;
            if (i < 3) {
              break label287;
            }
            bool = true;
            a(localk, bool, localCursor.getCount());
            j = i;
            if (!bool)
            {
              localCursor.moveToNext();
              continue;
            }
          }
        }
      }
      catch (Exception localException)
      {
        int j;
        ad.e("MicroMsg.IPCallUserProfileUI", "initRecordList, error: %s", new Object[] { localException.getMessage() });
        return;
        localCursor = i.ddN().anD(this.dIm);
        break;
        if (j <= 0)
        {
          this.uUQ.setVisibility(8);
          return;
        }
        if (localCursor.getCount() < 4) {
          continue;
        }
        deM();
        continue;
      }
      finally
      {
        localCursor.close();
        AppMethodBeat.o(26013);
      }
      label262:
      this.uUQ.setVisibility(8);
      this.uUU.setVisibility(8);
      AppMethodBeat.o(26013);
      return;
      label287:
      boolean bool = false;
    }
  }
  
  private void deM()
  {
    AppMethodBeat.i(26015);
    View localView = LayoutInflater.from(this).inflate(2131495146, this.uUQ, false);
    this.uUQ.addView(localView);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(25996);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        localObject = new Intent(IPCallUserProfileUI.this, IPCallAllRecordUI.class);
        if (!bt.isNullOrNil(IPCallUserProfileUI.e(IPCallUserProfileUI.this))) {
          ((Intent)localObject).putExtra("IPCallAllRecordUI_contactId", IPCallUserProfileUI.e(IPCallUserProfileUI.this));
        }
        for (;;)
        {
          ((Intent)localObject).putExtra("IPCallAllRecordUI_isSinglePhoneNumber", IPCallUserProfileUI.g(IPCallUserProfileUI.this));
          paramAnonymousView = IPCallUserProfileUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$11", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$11", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25996);
          return;
          if (!bt.isNullOrNil(IPCallUserProfileUI.f(IPCallUserProfileUI.this))) {
            ((Intent)localObject).putExtra("IPCallAllRecordUI_phoneNumber", IPCallUserProfileUI.f(IPCallUserProfileUI.this));
          }
        }
      }
    });
    AppMethodBeat.o(26015);
  }
  
  private void o(final String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(26010);
    View localView = LayoutInflater.from(this).inflate(2131495143, this.uUP, false);
    Object localObject = (LinearLayout)localView.findViewById(2131301448);
    if (!paramBoolean) {
      ((LinearLayout)localObject).setBackgroundDrawable(null);
    }
    for (;;)
    {
      localObject = (TextView)localView.findViewById(2131303239);
      final TextView localTextView = (TextView)localView.findViewById(2131303238);
      localTextView.setText(com.tencent.mm.plugin.ipcall.a.a.aof(com.tencent.mm.plugin.ipcall.a.c.aoj(paramString)));
      ((TextView)localObject).setText(com.tencent.mm.plugin.ipcall.a.a.IP(paramInt));
      localView.setClickable(true);
      localView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25997);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          IPCallUserProfileUI.a(IPCallUserProfileUI.this, paramString);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(25997);
        }
      });
      localView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(25998);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
          IPCallUserProfileUI.a(IPCallUserProfileUI.this, localTextView);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(25998);
          return true;
        }
      });
      this.uUP.addView(localView);
      AppMethodBeat.o(26010);
      return;
      ((LinearLayout)localObject).setBackgroundDrawable(getResources().getDrawable(2131232867));
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494509;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(26017);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(26017);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26008);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.g.yhR.f(12061, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(25994);
        IPCallUserProfileUI.this.finish();
        AppMethodBeat.o(25994);
        return true;
      }
    });
    setMMTitle(2131760472);
    this.fRd = ((ImageView)findViewById(2131297008));
    this.uUN = ((TextView)findViewById(2131305595));
    this.uUO = ((TextView)findViewById(2131306958));
    this.uUP = ((LinearLayout)findViewById(2131303484));
    this.uUR = ((TextView)findViewById(2131303482));
    this.uUT = ((TextView)findViewById(2131303481));
    this.uUS = ((TextView)findViewById(2131303480));
    this.uUQ = ((LinearLayout)findViewById(2131303487));
    this.uUU = ((TextView)findViewById(2131303904));
    this.uUV = ((TextView)findViewById(2131301063));
    this.uUW = ((Button)findViewById(2131303464));
    this.dKb = getIntent().getStringExtra("IPCallProfileUI_contactid");
    this.uUX = getIntent().getStringExtra("IPCallProfileUI_systemUsername");
    this.uUY = getIntent().getStringExtra("IPCallProfileUI_wechatUsername");
    this.dIm = getIntent().getStringExtra("IPCallProfileUI_phonenumber");
    this.uVc = getIntent().getBooleanExtra("IPCallProfileUI_isNeedShowRecord", false);
    if (!bt.isNullOrNil(this.dKb))
    {
      this.uUZ = com.tencent.mm.plugin.ipcall.a.a.aO(this, this.dKb);
      if (this.uUZ != null) {
        this.fRd.setImageBitmap(this.uUZ);
      }
    }
    if ((this.uUZ == null) && (!bt.isNullOrNil(this.uUY)))
    {
      this.uUZ = com.tencent.mm.ak.c.a(this.uUY, false, -1, null);
      if (this.uUZ != null) {
        this.fRd.setImageBitmap(this.uUZ);
      }
    }
    if (!bt.isNullOrNil(this.uUX))
    {
      this.uUN.setText(this.uUX);
      if ((bt.isNullOrNil(this.uUY)) || (this.uUY.endsWith("@stranger"))) {
        break label541;
      }
      paramBundle = getString(2131760473, new Object[] { v.zf(this.uUY) });
      this.uUO.setText(com.tencent.mm.pluginsdk.ui.span.k.c(this, paramBundle));
    }
    label541:
    boolean bool;
    for (;;)
    {
      if (!bt.isNullOrNil(this.dKb))
      {
        if (!com.tencent.mm.pluginsdk.permission.b.n(this, "android.permission.READ_CONTACTS"))
        {
          ad.e("MicroMsg.IPCallUserProfileUI", "no contact permission");
          AppMethodBeat.o(26008);
          return;
          if (bt.isNullOrNil(this.dIm)) {
            break;
          }
          this.uUN.setText(com.tencent.mm.plugin.ipcall.a.a.aof(this.dIm));
          break;
          this.uUO.setVisibility(8);
          continue;
        }
        this.uVb = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id=?", new String[] { this.dKb }, null);
        if (this.uVb.getCount() > 1) {
          break label747;
        }
        bool = true;
        this.uQk = bool;
      }
    }
    deL();
    this.uUT.setVisibility(8);
    this.uUS.setVisibility(8);
    this.uUR.setVisibility(8);
    this.uUW.setVisibility(8);
    this.uUV.setVisibility(8);
    if ((!bt.isNullOrNil(this.uUY)) && (!bt.isNullOrNil(this.uUX)))
    {
      ba.aBQ();
      paramBundle = com.tencent.mm.model.c.azp().Bf(this.uUY);
      if ((paramBundle != null) && (!com.tencent.mm.o.b.lM(paramBundle.field_type)))
      {
        this.uUW.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(26003);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            com.tencent.mm.plugin.report.service.g.yhR.f(12766, new Object[] { Integer.valueOf(3) });
            paramAnonymousView = new com.tencent.mm.pluginsdk.ui.applet.a(IPCallUserProfileUI.this, new a.a()
            {
              public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2)
              {
                AppMethodBeat.i(26001);
                ad.d("MicroMsg.IPCallUserProfileUI", "canAddContact, ok: %b, hasSentVerify: %b, respUsername: %s, itemID: %s", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2), paramAnonymous2String1, paramAnonymous2String2 });
                if (paramAnonymous2Boolean1)
                {
                  IPCallUserProfileUI.a(IPCallUserProfileUI.this).setVisibility(8);
                  IPCallUserProfileUI.b(IPCallUserProfileUI.this).setVisibility(8);
                  IPCallUserProfileUI.b(IPCallUserProfileUI.this, paramAnonymous2String1);
                }
                AppMethodBeat.o(26001);
              }
            });
            localObject = new LinkedList();
            ((LinkedList)localObject).add(Integer.valueOf(86));
            paramAnonymousView.EUN = new a.b()
            {
              public final boolean az(String paramAnonymous2String, int paramAnonymous2Int)
              {
                AppMethodBeat.i(26002);
                Intent localIntent = new Intent();
                localIntent.putExtra("Contact_User", IPCallUserProfileUI.c(IPCallUserProfileUI.this));
                localIntent.putExtra("Contact_Scene", 13);
                localIntent.putExtra(e.c.IUp, paramAnonymous2String);
                paramAnonymous2Int = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHe, 0);
                String str = ".ui.SayHiWithSnsPermissionUI";
                if ((!am.aSQ(IPCallUserProfileUI.c(IPCallUserProfileUI.this))) && (paramAnonymous2Int == 1)) {
                  paramAnonymous2String = ".ui.SayHiWithSnsPermissionUI2";
                }
                for (;;)
                {
                  d.b(IPCallUserProfileUI.this, "profile", paramAnonymous2String, localIntent);
                  AppMethodBeat.o(26002);
                  return true;
                  paramAnonymous2String = str;
                  if (!am.aSQ(IPCallUserProfileUI.c(IPCallUserProfileUI.this)))
                  {
                    paramAnonymous2String = str;
                    if (paramAnonymous2Int == 2) {
                      paramAnonymous2String = ".ui.SayHiWithSnsPermissionUI3";
                    }
                  }
                }
              }
            };
            paramAnonymousView.b(IPCallUserProfileUI.c(IPCallUserProfileUI.this), (LinkedList)localObject, true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26003);
          }
        });
        this.uUW.setText(2131760465);
        this.uUW.setVisibility(0);
      }
    }
    for (;;)
    {
      deJ();
      AppMethodBeat.o(26008);
      return;
      label747:
      bool = false;
      break;
      if ((!bt.isNullOrNil(this.dKb)) && (!bt.isNullOrNil(this.uUX)))
      {
        deK();
        this.uUW.setText(2131760470);
      }
      else if (!bt.isNullOrNil(this.dIm))
      {
        this.uUS.setVisibility(0);
        this.uUT.setVisibility(0);
        paramBundle = aj.getContext();
        Intent localIntent = new Intent("android.intent.action.INSERT");
        localIntent.setType("vnd.android.cursor.dir/contact");
        localIntent.putExtra("phone", "10086");
        if (bt.aj(paramBundle, localIntent)) {
          this.uUR.setVisibility(0);
        }
        this.uUR.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(26005);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            try
            {
              com.tencent.mm.plugin.report.service.g.yhR.f(12061, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
              localObject = new Intent("android.intent.action.INSERT");
              ((Intent)localObject).setType("vnd.android.cursor.dir/contact");
              ((Intent)localObject).putExtra("phone", IPCallUserProfileUI.f(IPCallUserProfileUI.this));
              paramAnonymousView = IPCallUserProfileUI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(26005);
              return;
            }
            catch (Exception paramAnonymousView)
            {
              for (;;)
              {
                ad.e("MicroMsg.IPCallUserProfileUI", paramAnonymousView.getMessage());
              }
            }
          }
        });
        this.uUS.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(26006);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            IPCallUserProfileUI.a(IPCallUserProfileUI.this, IPCallUserProfileUI.f(IPCallUserProfileUI.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26006);
          }
        });
        this.uUT.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(25995);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            com.tencent.mm.plugin.report.service.g.yhR.f(12766, new Object[] { Integer.valueOf(4) });
            com.tencent.mm.plugin.ipcall.a.c.aok(IPCallUserProfileUI.f(IPCallUserProfileUI.this));
            Toast.makeText(IPCallUserProfileUI.this, 2131760464, 0).show();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallUserProfileUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(25995);
          }
        });
        deK();
        this.uUW.setText(2131760470);
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26016);
    super.onResume();
    if (this.uVa)
    {
      this.uVa = false;
      this.uUQ.removeAllViews();
      deL();
    }
    AppMethodBeat.o(26016);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI
 * JD-Core Version:    0.7.0.1
 */