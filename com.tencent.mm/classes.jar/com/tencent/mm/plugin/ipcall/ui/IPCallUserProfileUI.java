package com.tencent.mm.plugin.ipcall.ui;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ag.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.ipcall.a.g.d;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.g.l;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.ArrayList;

public class IPCallUserProfileUI
  extends MMActivity
{
  private String caK;
  private String caM;
  private ImageView dpY;
  private boolean luD = false;
  private Bitmap lzA;
  private boolean lzB;
  private Cursor lzC = null;
  private boolean lzD = false;
  private com.tencent.mm.plugin.ipcall.a.e.e lzE = new com.tencent.mm.plugin.ipcall.a.e.e();
  private TextView lzo;
  private TextView lzp;
  private LinearLayout lzq;
  private LinearLayout lzr;
  private TextView lzs;
  private TextView lzt;
  private TextView lzu;
  private TextView lzv;
  private TextView lzw;
  private Button lzx;
  private String lzy;
  private String lzz;
  
  /* Error */
  private static String FS(String paramString)
  {
    // Byte code:
    //   0: invokestatic 60	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   3: ldc 62
    //   5: invokestatic 68	com/tencent/mm/pluginsdk/permission/a:j	(Landroid/content/Context;Ljava/lang/String;)Z
    //   8: ifne +12 -> 20
    //   11: ldc 70
    //   13: ldc 72
    //   15: invokestatic 78	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: aconst_null
    //   19: areturn
    //   20: invokestatic 60	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   23: invokevirtual 84	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   26: getstatic 90	android/provider/ContactsContract$CommonDataKinds$Phone:CONTENT_URI	Landroid/net/Uri;
    //   29: aconst_null
    //   30: ldc 92
    //   32: iconst_1
    //   33: anewarray 94	java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: aload_0
    //   39: aastore
    //   40: aconst_null
    //   41: invokevirtual 100	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   44: astore 4
    //   46: aload 4
    //   48: ifnull -30 -> 18
    //   51: aload 4
    //   53: invokeinterface 106 1 0
    //   58: istore_1
    //   59: iload_1
    //   60: ifeq +139 -> 199
    //   63: ldc 108
    //   65: astore_0
    //   66: aload_0
    //   67: astore_2
    //   68: aload_0
    //   69: astore_3
    //   70: aload 4
    //   72: invokeinterface 111 1 0
    //   77: ifne +125 -> 202
    //   80: aload_0
    //   81: astore_2
    //   82: aload 4
    //   84: aload 4
    //   86: ldc 113
    //   88: invokeinterface 117 2 0
    //   93: invokeinterface 121 2 0
    //   98: astore_3
    //   99: aload_0
    //   100: astore_2
    //   101: new 123	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   108: aload_0
    //   109: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_3
    //   113: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc 130
    //   118: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: astore_0
    //   125: aload_0
    //   126: astore_2
    //   127: aload 4
    //   129: invokeinterface 137 1 0
    //   134: pop
    //   135: goto -69 -> 66
    //   138: astore_0
    //   139: ldc 70
    //   141: ldc 139
    //   143: iconst_2
    //   144: anewarray 141	java/lang/Object
    //   147: dup
    //   148: iconst_0
    //   149: aload_0
    //   150: invokevirtual 144	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   153: aastore
    //   154: dup
    //   155: iconst_1
    //   156: aload_0
    //   157: invokevirtual 148	java/lang/Object:getClass	()Ljava/lang/Class;
    //   160: invokevirtual 153	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   163: aastore
    //   164: invokestatic 156	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   167: aload 4
    //   169: invokeinterface 159 1 0
    //   174: aload_2
    //   175: astore_0
    //   176: aload_2
    //   177: ldc 130
    //   179: invokevirtual 162	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   182: iflt +15 -> 197
    //   185: aload_2
    //   186: iconst_0
    //   187: aload_2
    //   188: ldc 130
    //   190: invokevirtual 162	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   193: invokevirtual 166	java/lang/String:substring	(II)Ljava/lang/String;
    //   196: astore_0
    //   197: aload_0
    //   198: areturn
    //   199: ldc 108
    //   201: astore_3
    //   202: aload 4
    //   204: invokeinterface 159 1 0
    //   209: aload_3
    //   210: astore_2
    //   211: goto -37 -> 174
    //   214: astore_0
    //   215: aload 4
    //   217: invokeinterface 159 1 0
    //   222: aload_0
    //   223: athrow
    //   224: astore_0
    //   225: ldc 108
    //   227: astore_2
    //   228: goto -89 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	paramString	String
    //   58	2	1	bool	boolean
    //   67	161	2	localObject	Object
    //   69	141	3	str	String
    //   44	172	4	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   70	80	138	java/lang/Exception
    //   82	99	138	java/lang/Exception
    //   101	125	138	java/lang/Exception
    //   127	135	138	java/lang/Exception
    //   51	59	214	finally
    //   70	80	214	finally
    //   82	99	214	finally
    //   101	125	214	finally
    //   127	135	214	finally
    //   139	167	214	finally
    //   51	59	224	java/lang/Exception
  }
  
  private void bdg()
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    if ((this.lzC != null) && (this.lzC.getCount() > 0))
    {
      for (;;)
      {
        try
        {
          if ((!this.lzC.moveToFirst()) || (this.lzC.isAfterLast())) {
            break label204;
          }
          i += 1;
          str = this.lzC.getString(this.lzC.getColumnIndex("data1"));
          j = this.lzC.getInt(this.lzC.getColumnIndex("data2"));
          if (!localArrayList.contains(str))
          {
            localArrayList.add(str);
            if (i != this.lzC.getCount()) {
              continue;
            }
            n(str, j, false);
          }
        }
        catch (Exception localException)
        {
          String str;
          int j;
          y.e("MicroMsg.IPCallUserProfileUI", "initPhoneNumberList error: %s", new Object[] { localException.getMessage() });
          return;
          n(str, j, true);
          continue;
        }
        finally
        {
          this.lzC.close();
        }
        this.lzC.moveToNext();
      }
      label204:
      this.lzC.close();
      return;
    }
    this.lzq.setVisibility(8);
  }
  
  private void bdh()
  {
    this.lzx.setOnClickListener(new IPCallUserProfileUI.9(this));
  }
  
  private void bdi()
  {
    if (!this.lzD)
    {
      this.lzr.setVisibility(8);
      this.lzv.setVisibility(8);
    }
    Object localObject1;
    if (!bk.bl(this.caK))
    {
      localObject1 = this.caK;
      if (!bk.bl((String)localObject1))
      {
        localObject1 = i.bcm().FA((String)localObject1);
        if ((localObject1 != null) && (((com.tencent.mm.plugin.ipcall.a.g.c)localObject1).ujK != -1L))
        {
          long l = ((com.tencent.mm.plugin.ipcall.a.g.c)localObject1).ujK;
          localObject1 = i.bcn().dXw.query("IPCallRecord", l.lsR, "addressId=?", new String[] { String.valueOf(l) }, null, null, "calltime desc limit 4");
          if ((localObject1 == null) || (((Cursor)localObject1).getCount() <= 0)) {
            break label596;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        int i;
        if (((Cursor)localObject1).moveToFirst())
        {
          i = 0;
          j = i;
          if (!((Cursor)localObject1).isAfterLast())
          {
            Object localObject4 = new k();
            ((k)localObject4).d((Cursor)localObject1);
            i += 1;
            if (i < 3) {
              break label615;
            }
            j = 1;
            int k = ((Cursor)localObject1).getCount();
            Object localObject2 = LayoutInflater.from(this).inflate(R.i.profile_record_item, this.lzr, false);
            TextView localTextView1 = (TextView)((View)localObject2).findViewById(R.h.profile_record_calltime_tv);
            TextView localTextView2 = (TextView)((View)localObject2).findViewById(R.h.profile_record_phonenumber_tv);
            TextView localTextView3 = (TextView)((View)localObject2).findViewById(R.h.profile_record_status_duration_tv);
            localTextView2.setText(com.tencent.mm.plugin.ipcall.b.a.Ge(((k)localObject4).field_phonenumber));
            if (((k)localObject4).field_duration > 0L)
            {
              localTextView3.setText(com.tencent.mm.plugin.ipcall.b.c.fa(((k)localObject4).field_duration));
              localTextView1.setText(com.tencent.mm.plugin.ipcall.b.c.eY(((k)localObject4).field_calltime));
              if (j != 0)
              {
                ((View)localObject2).setBackgroundDrawable(getResources().getDrawable(R.g.profile_record_background_with_line));
                int m = getResources().getDimensionPixelSize(R.f.profile_info_basic_left_right_margin);
                ((View)localObject2).setPadding(m, 0, m, 0);
              }
              if (1 == k)
              {
                localObject4 = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
                ((LinearLayout.LayoutParams)localObject4).height = com.tencent.mm.cb.a.aa(this.mController.uMN, R.f.only_one_record_layout_height);
                ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject4);
              }
              this.lzr.addView((View)localObject2);
              if (j != 0) {
                continue;
              }
              ((Cursor)localObject1).moveToNext();
              continue;
              localObject1 = null;
              break;
              localObject1 = i.bcn();
              localObject2 = this.caM;
              localObject1 = ((l)localObject1).dXw.query("IPCallRecord", l.lsR, "phonenumber=?", new String[] { localObject2 }, null, null, "calltime desc limit 4");
              break;
            }
            localTextView3.setText(com.tencent.mm.plugin.ipcall.b.c.sV(((k)localObject4).field_status));
            continue;
          }
        }
        View localView;
        this.lzr.setVisibility(8);
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.IPCallUserProfileUI", "initRecordList, error: %s", new Object[] { localException.getMessage() });
        return;
        j = i;
        if (j <= 0)
        {
          this.lzr.setVisibility(8);
          return;
        }
        if (((Cursor)localObject1).getCount() < 4) {
          continue;
        }
        localView = LayoutInflater.from(this).inflate(R.i.profile_record_item_see_more, this.lzr, false);
        this.lzr.addView(localView);
        localView.setOnClickListener(new IPCallUserProfileUI.3(this));
        continue;
      }
      finally
      {
        ((Cursor)localObject1).close();
      }
      label596:
      this.lzv.setVisibility(8);
      return;
      label615:
      int j = 0;
    }
  }
  
  private void n(String paramString, int paramInt, boolean paramBoolean)
  {
    View localView = LayoutInflater.from(this).inflate(R.i.profile_phonenumber_item, this.lzq, false);
    Object localObject = (LinearLayout)localView.findViewById(R.h.list_item_layot);
    if (!paramBoolean) {
      ((LinearLayout)localObject).setBackgroundDrawable(null);
    }
    for (;;)
    {
      localObject = (TextView)localView.findViewById(R.h.phonenumber_type_tv);
      TextView localTextView = (TextView)localView.findViewById(R.h.phonenumber_tv);
      localTextView.setText(com.tencent.mm.plugin.ipcall.b.a.Ge(com.tencent.mm.plugin.ipcall.b.c.Gi(paramString)));
      ((TextView)localObject).setText(com.tencent.mm.plugin.ipcall.b.a.sU(paramInt));
      localView.setClickable(true);
      localView.setOnClickListener(new IPCallUserProfileUI.4(this, paramString));
      localView.setOnLongClickListener(new IPCallUserProfileUI.5(this, localTextView));
      this.lzq.addView(localView);
      return;
      ((LinearLayout)localObject).setBackgroundDrawable(getResources().getDrawable(R.g.list_item_normal));
    }
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.ip_call_user_profile_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    h.nFQ.f(12061, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    setBackBtn(new IPCallUserProfileUI.1(this));
    setMMTitle(R.l.ip_call_profile_title);
    this.dpY = ((ImageView)findViewById(R.h.avatar_iv));
    this.lzo = ((TextView)findViewById(R.h.system_addrbook_username_tv));
    this.lzp = ((TextView)findViewById(R.h.wechat_username_tv));
    this.lzq = ((LinearLayout)findViewById(R.h.profile_phonenumber_ll));
    this.lzs = ((TextView)findViewById(R.h.profile_op_save_phonenumber_button));
    this.lzu = ((TextView)findViewById(R.h.profile_op_copy_phonenumber_button));
    this.lzt = ((TextView)findViewById(R.h.profile_op_call_phonenumber_button));
    this.lzr = ((LinearLayout)findViewById(R.h.profile_record_ll));
    this.lzv = ((TextView)findViewById(R.h.record_title));
    this.lzw = ((TextView)findViewById(R.h.invite_friend_text));
    this.lzx = ((Button)findViewById(R.h.profile_invite_op_btn));
    this.caK = getIntent().getStringExtra("IPCallProfileUI_contactid");
    this.lzy = getIntent().getStringExtra("IPCallProfileUI_systemUsername");
    this.lzz = getIntent().getStringExtra("IPCallProfileUI_wechatUsername");
    this.caM = getIntent().getStringExtra("IPCallProfileUI_phonenumber");
    this.lzD = getIntent().getBooleanExtra("IPCallProfileUI_isNeedShowRecord", false);
    if (!bk.bl(this.caK))
    {
      this.lzA = com.tencent.mm.plugin.ipcall.b.a.ay(this, this.caK);
      if (this.lzA != null) {
        this.dpY.setImageBitmap(this.lzA);
      }
    }
    if ((this.lzA == null) && (!bk.bl(this.lzz)))
    {
      this.lzA = b.a(this.lzz, false, -1);
      if (this.lzA != null) {
        this.dpY.setImageBitmap(this.lzA);
      }
    }
    if (!bk.bl(this.lzy))
    {
      this.lzo.setText(this.lzy);
      if ((bk.bl(this.lzz)) || (this.lzz.endsWith("@stranger"))) {
        break label525;
      }
      paramBundle = getString(R.l.ip_call_profile_wechat_username_format, new Object[] { r.gV(this.lzz) });
      this.lzp.setText(j.b(this, paramBundle));
    }
    label525:
    boolean bool;
    for (;;)
    {
      if (!bk.bl(this.caK))
      {
        if (!com.tencent.mm.pluginsdk.permission.a.j(this, "android.permission.READ_CONTACTS"))
        {
          y.e("MicroMsg.IPCallUserProfileUI", "no contact permission");
          return;
          if (bk.bl(this.caM)) {
            break;
          }
          this.lzo.setText(com.tencent.mm.plugin.ipcall.b.a.Ge(this.caM));
          break;
          this.lzp.setVisibility(8);
          continue;
        }
        this.lzC = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id=?", new String[] { this.caK }, null);
        if (this.lzC.getCount() > 1) {
          break label724;
        }
        bool = true;
        this.luD = bool;
      }
    }
    bdi();
    this.lzu.setVisibility(8);
    this.lzt.setVisibility(8);
    this.lzs.setVisibility(8);
    this.lzx.setVisibility(8);
    this.lzw.setVisibility(8);
    if ((!bk.bl(this.lzz)) && (!bk.bl(this.lzy)))
    {
      au.Hx();
      paramBundle = com.tencent.mm.model.c.Fw().abl(this.lzz);
      if ((paramBundle != null) && (!com.tencent.mm.n.a.gR(paramBundle.field_type)))
      {
        this.lzx.setOnClickListener(new IPCallUserProfileUI.8(this));
        this.lzx.setText(R.l.ip_call_profile_add_wechat_friend_btn);
        this.lzx.setVisibility(0);
      }
    }
    for (;;)
    {
      bdg();
      return;
      label724:
      bool = false;
      break;
      if ((!bk.bl(this.caK)) && (!bk.bl(this.lzy)))
      {
        bdh();
        this.lzx.setText(R.l.ip_call_profile_invite_wechat_friend_btn);
      }
      else if (!bk.bl(this.caM))
      {
        this.lzt.setVisibility(0);
        this.lzu.setVisibility(0);
        paramBundle = ae.getContext();
        Intent localIntent = new Intent("android.intent.action.INSERT");
        localIntent.setType("vnd.android.cursor.dir/contact");
        localIntent.putExtra("phone", "10086");
        if (bk.i(paramBundle, localIntent)) {
          this.lzs.setVisibility(0);
        }
        this.lzs.setOnClickListener(new IPCallUserProfileUI.10(this));
        this.lzt.setOnClickListener(new IPCallUserProfileUI.11(this));
        this.lzu.setOnClickListener(new IPCallUserProfileUI.2(this));
        bdh();
        this.lzx.setText(R.l.ip_call_profile_invite_wechat_friend_btn);
      }
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.lzB)
    {
      this.lzB = false;
      this.lzr.removeAllViews();
      bdi();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI
 * JD-Core Version:    0.7.0.1
 */