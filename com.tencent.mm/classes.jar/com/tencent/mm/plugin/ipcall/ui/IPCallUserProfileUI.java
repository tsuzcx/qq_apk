package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.ipcall.a.e.e;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.g.l;
import com.tencent.mm.plugin.ipcall.a.g.m;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public class IPCallUserProfileUI
  extends MMActivity
{
  private String cHB;
  private String cJk;
  private ImageView ehv;
  private boolean nRV;
  private TextView nWA;
  private TextView nWB;
  private LinearLayout nWC;
  private LinearLayout nWD;
  private TextView nWE;
  private TextView nWF;
  private TextView nWG;
  private TextView nWH;
  private TextView nWI;
  private Button nWJ;
  private String nWK;
  private String nWL;
  private Bitmap nWM;
  private boolean nWN;
  private Cursor nWO;
  private boolean nWP;
  private e nWQ;
  
  public IPCallUserProfileUI()
  {
    AppMethodBeat.i(22384);
    this.nRV = false;
    this.nWO = null;
    this.nWP = false;
    this.nWQ = new e();
    AppMethodBeat.o(22384);
  }
  
  /* Error */
  private static String Ru(String paramString)
  {
    // Byte code:
    //   0: sipush 22388
    //   3: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 69	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   9: ldc 71
    //   11: invokestatic 76	com/tencent/mm/pluginsdk/permission/b:o	(Landroid/content/Context;Ljava/lang/String;)Z
    //   14: ifne +18 -> 32
    //   17: ldc 78
    //   19: ldc 80
    //   21: invokestatic 86	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: sipush 22388
    //   27: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aconst_null
    //   31: areturn
    //   32: invokestatic 69	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   35: invokevirtual 92	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   38: getstatic 98	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   41: aconst_null
    //   42: ldc 100
    //   44: iconst_1
    //   45: anewarray 102	java/lang/String
    //   48: dup
    //   49: iconst_0
    //   50: aload_0
    //   51: aastore
    //   52: aconst_null
    //   53: invokevirtual 108	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   56: astore 4
    //   58: aload 4
    //   60: ifnonnull +11 -> 71
    //   63: sipush 22388
    //   66: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aconst_null
    //   70: areturn
    //   71: aload 4
    //   73: invokeinterface 114 1 0
    //   78: istore_1
    //   79: iload_1
    //   80: ifeq +145 -> 225
    //   83: ldc 116
    //   85: astore_0
    //   86: aload_0
    //   87: astore_2
    //   88: aload_0
    //   89: astore_3
    //   90: aload 4
    //   92: invokeinterface 119 1 0
    //   97: ifne +131 -> 228
    //   100: aload_0
    //   101: astore_2
    //   102: aload 4
    //   104: aload 4
    //   106: ldc 121
    //   108: invokeinterface 125 2 0
    //   113: invokeinterface 129 2 0
    //   118: astore_3
    //   119: aload_0
    //   120: astore_2
    //   121: new 131	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   128: aload_0
    //   129: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_3
    //   133: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc 138
    //   138: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: astore_0
    //   145: aload_0
    //   146: astore_2
    //   147: aload 4
    //   149: invokeinterface 145 1 0
    //   154: pop
    //   155: goto -69 -> 86
    //   158: astore_0
    //   159: ldc 78
    //   161: ldc 147
    //   163: iconst_2
    //   164: anewarray 149	java/lang/Object
    //   167: dup
    //   168: iconst_0
    //   169: aload_0
    //   170: invokevirtual 152	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   173: aastore
    //   174: dup
    //   175: iconst_1
    //   176: aload_0
    //   177: invokevirtual 156	java/lang/Object:getClass	()Ljava/lang/Class;
    //   180: invokevirtual 161	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   183: aastore
    //   184: invokestatic 164	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   187: aload 4
    //   189: invokeinterface 167 1 0
    //   194: aload_2
    //   195: astore_0
    //   196: aload_2
    //   197: ldc 138
    //   199: invokevirtual 170	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   202: iflt +15 -> 217
    //   205: aload_2
    //   206: iconst_0
    //   207: aload_2
    //   208: ldc 138
    //   210: invokevirtual 170	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   213: invokevirtual 174	java/lang/String:substring	(II)Ljava/lang/String;
    //   216: astore_0
    //   217: sipush 22388
    //   220: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   223: aload_0
    //   224: areturn
    //   225: ldc 116
    //   227: astore_3
    //   228: aload 4
    //   230: invokeinterface 167 1 0
    //   235: aload_3
    //   236: astore_2
    //   237: goto -43 -> 194
    //   240: astore_0
    //   241: aload 4
    //   243: invokeinterface 167 1 0
    //   248: sipush 22388
    //   251: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   254: aload_0
    //   255: athrow
    //   256: astore_0
    //   257: ldc 116
    //   259: astore_2
    //   260: goto -101 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	paramString	String
    //   78	2	1	bool	boolean
    //   87	173	2	localObject	Object
    //   89	147	3	str	String
    //   56	186	4	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   90	100	158	java/lang/Exception
    //   102	119	158	java/lang/Exception
    //   121	145	158	java/lang/Exception
    //   147	155	158	java/lang/Exception
    //   71	79	240	finally
    //   90	100	240	finally
    //   102	119	240	finally
    //   121	145	240	finally
    //   147	155	240	finally
    //   159	187	240	finally
    //   71	79	256	java/lang/Exception
  }
  
  private void a(k paramk, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(22391);
    View localView = LayoutInflater.from(this).inflate(2130970472, this.nWD, false);
    TextView localTextView1 = (TextView)localView.findViewById(2131825273);
    TextView localTextView2 = (TextView)localView.findViewById(2131825274);
    TextView localTextView3 = (TextView)localView.findViewById(2131825275);
    localTextView2.setText(com.tencent.mm.plugin.ipcall.b.a.RG(paramk.field_phonenumber));
    if (paramk.field_duration > 0L) {
      localTextView3.setText(com.tencent.mm.plugin.ipcall.b.c.ky(paramk.field_duration));
    }
    for (;;)
    {
      localTextView1.setText(com.tencent.mm.plugin.ipcall.b.c.ku(paramk.field_calltime));
      if (paramBoolean)
      {
        localView.setBackgroundDrawable(getResources().getDrawable(2130839998));
        int i = getResources().getDimensionPixelSize(2131427445);
        localView.setPadding(i, 0, i, 0);
      }
      if (1 == paramInt)
      {
        paramk = (LinearLayout.LayoutParams)localView.getLayoutParams();
        paramk.height = com.tencent.mm.cb.a.ao(getContext(), 2131428617);
        localView.setLayoutParams(paramk);
      }
      this.nWD.addView(localView);
      AppMethodBeat.o(22391);
      return;
      localTextView3.setText(com.tencent.mm.plugin.ipcall.b.c.xX(paramk.field_status));
    }
  }
  
  private void bKq()
  {
    int i = 0;
    AppMethodBeat.i(22386);
    ArrayList localArrayList = new ArrayList();
    if ((this.nWO != null) && (this.nWO.getCount() > 0))
    {
      for (;;)
      {
        try
        {
          if ((!this.nWO.moveToFirst()) || (this.nWO.isAfterLast())) {
            break label222;
          }
          i += 1;
          str = this.nWO.getString(this.nWO.getColumnIndex("data1"));
          j = this.nWO.getInt(this.nWO.getColumnIndex("data2"));
          if (!localArrayList.contains(str))
          {
            localArrayList.add(str);
            if (i != this.nWO.getCount()) {
              continue;
            }
            o(str, j, false);
          }
        }
        catch (Exception localException)
        {
          String str;
          int j;
          ab.e("MicroMsg.IPCallUserProfileUI", "initPhoneNumberList error: %s", new Object[] { localException.getMessage() });
          return;
          o(str, j, true);
          continue;
        }
        finally
        {
          this.nWO.close();
          AppMethodBeat.o(22386);
        }
        this.nWO.moveToNext();
      }
      label222:
      this.nWO.close();
      AppMethodBeat.o(22386);
      return;
    }
    this.nWC.setVisibility(8);
    AppMethodBeat.o(22386);
  }
  
  private void bKr()
  {
    AppMethodBeat.i(22389);
    this.nWJ.setOnClickListener(new IPCallUserProfileUI.9(this));
    AppMethodBeat.o(22389);
  }
  
  private void bKs()
  {
    AppMethodBeat.i(22390);
    if (!this.nWP)
    {
      this.nWD.setVisibility(8);
      this.nWH.setVisibility(8);
    }
    Cursor localCursor;
    if (!bo.isNullOrNil(this.cJk))
    {
      localCursor = m.Rg(this.cJk);
      if ((localCursor == null) || (localCursor.getCount() <= 0)) {
        break label261;
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
            k localk = new k();
            localk.convertFrom(localCursor);
            i += 1;
            if (i < 3) {
              break label286;
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
        ab.e("MicroMsg.IPCallUserProfileUI", "initRecordList, error: %s", new Object[] { localException.getMessage() });
        return;
        localCursor = i.bJu().Re(this.cHB);
        break;
        if (j <= 0)
        {
          this.nWD.setVisibility(8);
          return;
        }
        if (localCursor.getCount() < 4) {
          continue;
        }
        bKt();
        continue;
      }
      finally
      {
        localCursor.close();
        AppMethodBeat.o(22390);
      }
      label261:
      this.nWD.setVisibility(8);
      this.nWH.setVisibility(8);
      AppMethodBeat.o(22390);
      return;
      label286:
      boolean bool = false;
    }
  }
  
  private void bKt()
  {
    AppMethodBeat.i(22392);
    View localView = LayoutInflater.from(this).inflate(2130970473, this.nWD, false);
    this.nWD.addView(localView);
    localView.setOnClickListener(new IPCallUserProfileUI.3(this));
    AppMethodBeat.o(22392);
  }
  
  private void o(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(22387);
    View localView = LayoutInflater.from(this).inflate(2130970470, this.nWC, false);
    Object localObject = (LinearLayout)localView.findViewById(2131826861);
    if (!paramBoolean) {
      ((LinearLayout)localObject).setBackgroundDrawable(null);
    }
    for (;;)
    {
      localObject = (TextView)localView.findViewById(2131826862);
      TextView localTextView = (TextView)localView.findViewById(2131825211);
      localTextView.setText(com.tencent.mm.plugin.ipcall.b.a.RG(com.tencent.mm.plugin.ipcall.b.c.RK(paramString)));
      ((TextView)localObject).setText(com.tencent.mm.plugin.ipcall.b.a.xW(paramInt));
      localView.setClickable(true);
      localView.setOnClickListener(new IPCallUserProfileUI.4(this, paramString));
      localView.setOnLongClickListener(new IPCallUserProfileUI.5(this, localTextView));
      this.nWC.addView(localView);
      AppMethodBeat.o(22387);
      return;
      ((LinearLayout)localObject).setBackgroundDrawable(getResources().getDrawable(2130839276));
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969931;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(22394);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(22394);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22385);
    super.onCreate(paramBundle);
    h.qsU.e(12061, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    setBackBtn(new IPCallUserProfileUI.1(this));
    setMMTitle(2131300871);
    this.ehv = ((ImageView)findViewById(2131821210));
    this.nWA = ((TextView)findViewById(2131825235));
    this.nWB = ((TextView)findViewById(2131825236));
    this.nWC = ((LinearLayout)findViewById(2131825239));
    this.nWE = ((TextView)findViewById(2131825242));
    this.nWG = ((TextView)findViewById(2131825241));
    this.nWF = ((TextView)findViewById(2131825240));
    this.nWD = ((LinearLayout)findViewById(2131825238));
    this.nWH = ((TextView)findViewById(2131825237));
    this.nWI = ((TextView)findViewById(2131825244));
    this.nWJ = ((Button)findViewById(2131825243));
    this.cJk = getIntent().getStringExtra("IPCallProfileUI_contactid");
    this.nWK = getIntent().getStringExtra("IPCallProfileUI_systemUsername");
    this.nWL = getIntent().getStringExtra("IPCallProfileUI_wechatUsername");
    this.cHB = getIntent().getStringExtra("IPCallProfileUI_phonenumber");
    this.nWP = getIntent().getBooleanExtra("IPCallProfileUI_isNeedShowRecord", false);
    if (!bo.isNullOrNil(this.cJk))
    {
      this.nWM = com.tencent.mm.plugin.ipcall.b.a.aH(this, this.cJk);
      if (this.nWM != null) {
        this.ehv.setImageBitmap(this.nWM);
      }
    }
    if ((this.nWM == null) && (!bo.isNullOrNil(this.nWL)))
    {
      this.nWM = com.tencent.mm.ah.b.b(this.nWL, false, -1);
      if (this.nWM != null) {
        this.ehv.setImageBitmap(this.nWM);
      }
    }
    if (!bo.isNullOrNil(this.nWK))
    {
      this.nWA.setText(this.nWK);
      if ((bo.isNullOrNil(this.nWL)) || (this.nWL.endsWith("@stranger"))) {
        break label537;
      }
      paramBundle = getString(2131300872, new Object[] { s.nE(this.nWL) });
      this.nWB.setText(j.b(this, paramBundle));
    }
    label537:
    boolean bool;
    for (;;)
    {
      if (!bo.isNullOrNil(this.cJk))
      {
        if (!com.tencent.mm.pluginsdk.permission.b.o(this, "android.permission.READ_CONTACTS"))
        {
          ab.e("MicroMsg.IPCallUserProfileUI", "no contact permission");
          AppMethodBeat.o(22385);
          return;
          if (bo.isNullOrNil(this.cHB)) {
            break;
          }
          this.nWA.setText(com.tencent.mm.plugin.ipcall.b.a.RG(this.cHB));
          break;
          this.nWB.setVisibility(8);
          continue;
        }
        this.nWO = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id=?", new String[] { this.cJk }, null);
        if (this.nWO.getCount() > 1) {
          break label742;
        }
        bool = true;
        this.nRV = bool;
      }
    }
    bKs();
    this.nWG.setVisibility(8);
    this.nWF.setVisibility(8);
    this.nWE.setVisibility(8);
    this.nWJ.setVisibility(8);
    this.nWI.setVisibility(8);
    if ((!bo.isNullOrNil(this.nWL)) && (!bo.isNullOrNil(this.nWK)))
    {
      aw.aaz();
      paramBundle = com.tencent.mm.model.c.YA().arw(this.nWL);
      if ((paramBundle != null) && (!com.tencent.mm.n.a.je(paramBundle.field_type)))
      {
        this.nWJ.setOnClickListener(new IPCallUserProfileUI.8(this));
        this.nWJ.setText(2131300864);
        this.nWJ.setVisibility(0);
      }
    }
    for (;;)
    {
      bKq();
      AppMethodBeat.o(22385);
      return;
      label742:
      bool = false;
      break;
      if ((!bo.isNullOrNil(this.cJk)) && (!bo.isNullOrNil(this.nWK)))
      {
        bKr();
        this.nWJ.setText(2131300869);
      }
      else if (!bo.isNullOrNil(this.cHB))
      {
        this.nWF.setVisibility(0);
        this.nWG.setVisibility(0);
        paramBundle = ah.getContext();
        Intent localIntent = new Intent("android.intent.action.INSERT");
        localIntent.setType("vnd.android.cursor.dir/contact");
        localIntent.putExtra("phone", "10086");
        if (bo.k(paramBundle, localIntent)) {
          this.nWE.setVisibility(0);
        }
        this.nWE.setOnClickListener(new IPCallUserProfileUI.10(this));
        this.nWF.setOnClickListener(new IPCallUserProfileUI.11(this));
        this.nWG.setOnClickListener(new IPCallUserProfileUI.2(this));
        bKr();
        this.nWJ.setText(2131300869);
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22393);
    super.onResume();
    if (this.nWN)
    {
      this.nWN = false;
      this.nWD.removeAllViews();
      bKs();
    }
    AppMethodBeat.o(22393);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI
 * JD-Core Version:    0.7.0.1
 */