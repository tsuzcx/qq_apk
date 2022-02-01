package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Display;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cf;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.contact.ac;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SeeRoomMemberUI
  extends MMActivity
  implements f, com.tencent.mm.chatroom.g.a.b
{
  private static int fSG = 5;
  private boolean dyF;
  private ab fLO;
  private boolean fMw;
  private String fPi;
  private String fQB;
  private int fQC;
  private String fQD;
  private boolean fQE;
  private com.tencent.mm.ui.base.p fQJ;
  private String fSA;
  private String fSB;
  private r fSC;
  private String fSD;
  private MMEditText fSE;
  private int fSF;
  private AdapterView.OnItemClickListener fSH;
  private GridView fSi;
  private b fSz;
  private int fq;
  private String mTitle;
  private String talker;
  private String username;
  
  public SeeRoomMemberUI()
  {
    AppMethodBeat.i(213559);
    this.fSH = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(213554);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousAdapterView = SeeRoomMemberUI.c(SeeRoomMemberUI.this).li(paramAnonymousInt);
        if (paramAnonymousAdapterView.type == 2)
        {
          ad.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Add member");
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(219L, 6L, 1L, true);
          SeeRoomMemberUI.f(SeeRoomMemberUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(213554);
          return;
        }
        if (paramAnonymousAdapterView.type == 3)
        {
          ad.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Delete member");
          SeeRoomMemberUI.g(SeeRoomMemberUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(213554);
          return;
        }
        if (paramAnonymousAdapterView.type == 1)
        {
          paramAnonymousAdapterView = SeeRoomMemberUI.c(SeeRoomMemberUI.this).li(paramAnonymousInt).contact;
          if (paramAnonymousAdapterView == null)
          {
            ad.e("MicroMsg.SeeRoomMemberUI", "cont is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(213554);
            return;
          }
          SeeRoomMemberUI.a(SeeRoomMemberUI.this, paramAnonymousAdapterView.field_username);
          paramAnonymousView = paramAnonymousAdapterView.field_nickname;
          localObject = SeeRoomMemberUI.a(SeeRoomMemberUI.e(SeeRoomMemberUI.this), SeeRoomMemberUI.h(SeeRoomMemberUI.this));
          if (!bt.isNullOrNil((String)localObject)) {
            break label332;
          }
          SeeRoomMemberUI.b(SeeRoomMemberUI.this, paramAnonymousAdapterView.adv());
        }
        for (;;)
        {
          ac.u(SeeRoomMemberUI.i(SeeRoomMemberUI.this).getText().toString(), 1, 6, paramAnonymousInt + 1);
          SeeRoomMemberUI.a(SeeRoomMemberUI.this, SeeRoomMemberUI.h(SeeRoomMemberUI.this), SeeRoomMemberUI.j(SeeRoomMemberUI.this), paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(213554);
          return;
          label332:
          SeeRoomMemberUI.b(SeeRoomMemberUI.this, (String)localObject);
        }
      }
    };
    AppMethodBeat.o(213559);
  }
  
  protected static String a(ab paramab, String paramString)
  {
    AppMethodBeat.i(12892);
    if (paramab == null)
    {
      AppMethodBeat.o(12892);
      return "";
    }
    paramab = paramab.zf(paramString);
    AppMethodBeat.o(12892);
    return paramab;
  }
  
  private static int bT(Context paramContext)
  {
    AppMethodBeat.i(12879);
    int i = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
    int j = (int)(paramContext.getResources().getDimension(2131165500) * 2.0F + paramContext.getResources().getDimension(2131165508));
    i = (int)((i - paramContext.getResources().getDimension(2131165489) * 1.0F) / j);
    ad.i("MicroMsg.SeeRoomMemberUI", "[getWrapColNum] :%s", new Object[] { Integer.valueOf(i) });
    fSG = i;
    AppMethodBeat.o(12879);
    return i;
  }
  
  /* Error */
  private static Object invokeMethod(Object paramObject, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    // Byte code:
    //   0: sipush 12893
    //   3: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnonnull +11 -> 18
    //   10: sipush 12893
    //   13: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: invokevirtual 533	java/lang/Object:getClass	()Ljava/lang/Class;
    //   22: astore 4
    //   24: aload 4
    //   26: ldc_w 411
    //   29: if_acmpeq +136 -> 165
    //   32: aload 4
    //   34: aload_1
    //   35: aload_3
    //   36: invokevirtual 539	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   39: astore 5
    //   41: aload 5
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +115 -> 160
    //   48: aload_1
    //   49: iconst_1
    //   50: invokevirtual 545	java/lang/reflect/Method:setAccessible	(Z)V
    //   53: aload_1
    //   54: aload_0
    //   55: aload_2
    //   56: invokevirtual 549	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   59: astore_0
    //   60: sipush 12893
    //   63: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_0
    //   67: areturn
    //   68: astore 5
    //   70: ldc 140
    //   72: aload 5
    //   74: ldc 112
    //   76: iconst_0
    //   77: anewarray 411	java/lang/Object
    //   80: invokestatic 553	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aload 4
    //   85: invokevirtual 556	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   88: astore 4
    //   90: goto -66 -> 24
    //   93: astore 5
    //   95: ldc 140
    //   97: aload 5
    //   99: ldc 112
    //   101: iconst_0
    //   102: anewarray 411	java/lang/Object
    //   105: invokestatic 553	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: goto -25 -> 83
    //   111: astore_0
    //   112: ldc 140
    //   114: aload_0
    //   115: ldc 112
    //   117: iconst_0
    //   118: anewarray 411	java/lang/Object
    //   121: invokestatic 553	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: aconst_null
    //   125: astore_0
    //   126: goto -66 -> 60
    //   129: astore_0
    //   130: ldc 140
    //   132: aload_0
    //   133: ldc 112
    //   135: iconst_0
    //   136: anewarray 411	java/lang/Object
    //   139: invokestatic 553	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: aconst_null
    //   143: astore_0
    //   144: goto -84 -> 60
    //   147: astore_0
    //   148: ldc 140
    //   150: aload_0
    //   151: ldc 112
    //   153: iconst_0
    //   154: anewarray 411	java/lang/Object
    //   157: invokestatic 553	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   160: aconst_null
    //   161: astore_0
    //   162: goto -102 -> 60
    //   165: aconst_null
    //   166: astore_1
    //   167: goto -123 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	paramObject	Object
    //   0	170	1	paramString	String
    //   0	170	2	paramArrayOfObject	Object[]
    //   0	170	3	paramArrayOfClass	Class[]
    //   22	67	4	localClass	Class
    //   39	3	5	localMethod	java.lang.reflect.Method
    //   68	5	5	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   93	5	5	localSecurityException	java.lang.SecurityException
    // Exception table:
    //   from	to	target	type
    //   32	41	68	java/lang/NoSuchMethodException
    //   32	41	93	java/lang/SecurityException
    //   53	60	111	java/lang/IllegalAccessException
    //   53	60	129	java/lang/IllegalArgumentException
    //   53	60	147	java/lang/reflect/InvocationTargetException
  }
  
  private void uZ(final String paramString)
  {
    AppMethodBeat.i(12884);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(12884);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramString);
    paramString = com.tencent.mm.roomsdk.a.b.aPF(this.fPi).a(this.fPi, localLinkedList, 0);
    paramString.b(new com.tencent.mm.roomsdk.a.b.b() {});
    paramString.c(new com.tencent.mm.roomsdk.a.b.b() {});
    getString(2131755906);
    paramString.a(this, getString(2131762595), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(213557);
        paramString.cancel();
        AppMethodBeat.o(213557);
      }
    });
    AppMethodBeat.o(12884);
  }
  
  public final void Yl()
  {
    AppMethodBeat.i(12881);
    ak localak = ((c)com.tencent.mm.kernel.g.ab(c.class)).azz();
    if (this.talker == null) {}
    for (String str = this.fPi;; str = this.talker)
    {
      this.fLO = localak.AN(str);
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(213555);
          if (SeeRoomMemberUI.c(SeeRoomMemberUI.this) != null) {
            SeeRoomMemberUI.c(SeeRoomMemberUI.this).S(this.fSK);
          }
          AppMethodBeat.o(213555);
        }
      });
      AppMethodBeat.o(12881);
      return;
    }
  }
  
  public final void Ym()
  {
    AppMethodBeat.i(213560);
    if (this.fLO != null) {
      setMMTitle(this.mTitle + "(" + this.fLO.aGo().size() + ")");
    }
    AppMethodBeat.o(213560);
  }
  
  public int getLayoutId()
  {
    return 2131495337;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12880);
    setMMTitle(this.mTitle + "(" + this.fQC + ")");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(12859);
        SeeRoomMemberUI.this.setResult(0);
        SeeRoomMemberUI.this.finish();
        AppMethodBeat.o(12859);
        return true;
      }
    });
    this.fSE = ((MMEditText)findViewById(2131302626));
    this.fSi = ((GridView)findViewById(2131297966));
    this.fSi.setNumColumns(bT(this));
    this.fSi.setColumnWidth(getResources().getDimensionPixelSize(2131165489));
    ab localab = this.fLO;
    String str = this.fPi;
    Object localObject = new LinkedList();
    if (!bt.isNullOrNil(this.fSA)) {
      localObject = bt.U(this.fSA.split(","));
    }
    ca localca = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azy().aqy("@t.qq.com");
    if (localca != null) {
      ((List)localObject).add(localca.name);
    }
    this.fSz = new b(this, localab, str, (List)localObject, this.fQD);
    this.fSE.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(12860);
        SeeRoomMemberUI.c(SeeRoomMemberUI.this).vb(paramAnonymousCharSequence.toString());
        AppMethodBeat.o(12860);
      }
    });
    this.fSi.setOnItemClickListener(this.fSH);
    this.fSi.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(213553);
        if (SeeRoomMemberUI.d(SeeRoomMemberUI.this))
        {
          paramAnonymousAdapterView = SeeRoomMemberUI.c(SeeRoomMemberUI.this).li(paramAnonymousInt).contact;
          if (paramAnonymousAdapterView == null)
          {
            AppMethodBeat.o(213553);
            return true;
          }
          paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
          if (SeeRoomMemberUI.e(SeeRoomMemberUI.this).field_roomowner.equals(paramAnonymousAdapterView))
          {
            AppMethodBeat.o(213553);
            return true;
          }
          h.a(SeeRoomMemberUI.this, SeeRoomMemberUI.this.getString(2131762597), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(213552);
              SeeRoomMemberUI.a(SeeRoomMemberUI.this, paramAnonymousInt);
              AppMethodBeat.o(213552);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          });
        }
        for (;;)
        {
          AppMethodBeat.o(213553);
          return true;
          ad.i("MicroMsg.SeeRoomMemberUI", "U are not a roomowner");
        }
      }
    });
    this.fSi.setAdapter(this.fSz);
    AppMethodBeat.o(12880);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    AppMethodBeat.i(12886);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    String str;
    ChatroomInfoUI.LocalHistoryInfo localLocalHistoryInfo;
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(12886);
      return;
    case 1: 
      if (paramIntent == null)
      {
        AppMethodBeat.o(12886);
        return;
      }
      str = paramIntent.getStringExtra("Select_Contact");
      localLocalHistoryInfo = (ChatroomInfoUI.LocalHistoryInfo)paramIntent.getParcelableExtra("select_record_msg_info");
      if ((w.zk(this.fPi)) && (!w.zn(this.fPi)) && (!com.tencent.mm.model.p.yE(str)))
      {
        h.c(this, getString(2131762644), getString(2131755906), true);
        AppMethodBeat.o(12886);
        return;
      }
      if (bt.nullAsNil(u.aAm()).equals(str)) {
        paramInt1 = 1;
      }
      for (;;)
      {
        label149:
        if (paramInt1 != 0)
        {
          h.c(this, getString(2131755154), getString(2131755906), true);
          AppMethodBeat.o(12886);
          return;
          Object localObject = com.tencent.mm.model.q.yQ(this.fPi);
          paramInt1 = i;
          if (localObject != null)
          {
            localObject = ((List)localObject).iterator();
            paramInt1 = 0;
            label207:
            if (((Iterator)localObject).hasNext())
            {
              if (!((String)((Iterator)localObject).next()).equals(str)) {
                break label335;
              }
              paramInt1 = 1;
            }
          }
        }
      }
    }
    label335:
    for (;;)
    {
      break label207;
      break label149;
      if (bt.U(str.split(",")) == null)
      {
        AppMethodBeat.o(12886);
        return;
      }
      str = paramIntent.getStringExtra("Select_Contact");
      long l = paramIntent.getLongExtra("select_record_fake_msg_id", 0L);
      new com.tencent.mm.chatroom.g.a(this, this.fPi, str, localLocalHistoryInfo, l, this);
      AppMethodBeat.o(12886);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(12886);
        return;
      }
      uZ(paramIntent.getStringExtra("Select_Contact"));
      break;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(12878);
    super.onConfigurationChanged(paramConfiguration);
    this.fSi.setNumColumns(bT(this));
    AppMethodBeat.o(12878);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12876);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(219L, 2L, 1L, true);
    com.tencent.mm.kernel.g.ajB().gAO.a(990, this);
    this.fPi = getIntent().getStringExtra("RoomInfo_Id");
    this.talker = getIntent().getStringExtra("Chat_User");
    this.fSB = getIntent().getStringExtra("Chatroom_member_list");
    this.dyF = getIntent().getBooleanExtra("Is_Chatroom", true);
    this.fMw = getIntent().getBooleanExtra("Is_Lbsroom", false);
    this.fQE = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.fQD = getIntent().getStringExtra("room_owner_name");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    ak localak = ((c)com.tencent.mm.kernel.g.ab(c.class)).azz();
    if (this.talker == null)
    {
      paramBundle = this.fPi;
      this.fLO = localak.AN(paramBundle);
      this.fQC = getIntent().getIntExtra("room_member_count", 0);
      this.fQB = getIntent().getStringExtra("room_name");
      this.fq = getIntent().getIntExtra("offset", 0);
      this.fSF = getIntent().getIntExtra("first_pos", 0);
      initView();
      if (this.fSz != null)
      {
        Yl();
        paramBundle = this.fSi;
        if (this.fSF * fSG >= this.fSz.getCount()) {
          break label336;
        }
      }
    }
    label336:
    for (int i = this.fSF * fSG;; i = this.fSz.getCount() - 1)
    {
      paramBundle.setSelection(i);
      this.fSi.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(12850);
          if (Build.VERSION.SDK_INT >= 19)
          {
            SeeRoomMemberUI.b(SeeRoomMemberUI.this).scrollListBy(SeeRoomMemberUI.a(SeeRoomMemberUI.this));
            AppMethodBeat.o(12850);
            return;
          }
          GridView localGridView = SeeRoomMemberUI.b(SeeRoomMemberUI.this);
          int i = -SeeRoomMemberUI.a(SeeRoomMemberUI.this);
          int j = -SeeRoomMemberUI.a(SeeRoomMemberUI.this);
          Class localClass1 = Integer.TYPE;
          Class localClass2 = Integer.TYPE;
          SeeRoomMemberUI.a(localGridView, "trackMotionScroll", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }, new Class[] { localClass1, localClass2 });
          AppMethodBeat.o(12850);
        }
      }, 100L);
      AppMethodBeat.o(12876);
      return;
      paramBundle = this.talker;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12883);
    com.tencent.mm.kernel.g.ajB().gAO.b(990, this);
    if ((this.fQJ != null) && (this.fQJ.isShowing())) {
      this.fQJ.dismiss();
    }
    super.onDestroy();
    AppMethodBeat.o(12883);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(12882);
    super.onPause();
    if (this.fSC != null) {
      this.fSC.fKE();
    }
    AppMethodBeat.o(12882);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12877);
    super.onResume();
    if (this.fSz != null) {
      this.fSz.vb(this.fSE.getText().toString());
    }
    AppMethodBeat.o(12877);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(12885);
    if ((this.fQJ != null) && (this.fQJ.isShowing())) {
      this.fQJ.dismiss();
    }
    paramString = com.tencent.mm.h.a.uz(paramString);
    if (paramString != null)
    {
      paramString.a(this, null, null);
      AppMethodBeat.o(12885);
      return;
    }
    AppMethodBeat.o(12885);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
  {
    am contact;
    int order = 0;
    int type;
    
    public a(int paramInt)
    {
      this.type = paramInt;
      this.contact = null;
    }
    
    public a(am paramam, int paramInt)
    {
      this.type = 1;
      this.contact = paramam;
      this.order = paramInt;
    }
  }
  
  final class b
    extends BaseAdapter
  {
    private List<SeeRoomMemberUI.a> dAa;
    private ab fLO;
    private List<String> fSL;
    public String fSM;
    private boolean fSN;
    private String fSO;
    private List<SeeRoomMemberUI.a> fSP;
    private com.tencent.mm.plugin.messenger.foundation.a.l fSQ;
    private Context mContext;
    private String roomId;
    
    public b(ab paramab, String paramString1, List<String> paramList, String paramString2)
    {
      AppMethodBeat.i(12868);
      this.fSN = false;
      this.fSO = null;
      this.dAa = new ArrayList();
      this.fLO = paramString1;
      this.roomId = paramList;
      this.fSL = paramString2;
      Object localObject;
      this.fSO = localObject;
      this.mContext = paramab;
      this.fSQ = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class));
      S(com.tencent.mm.model.q.yQ(paramList));
      AppMethodBeat.o(12868);
    }
    
    private void va(String paramString)
    {
      AppMethodBeat.i(12870);
      ArrayList localArrayList = new ArrayList();
      if (!bt.isNullOrNil(paramString))
      {
        Iterator localIterator = this.fSP.iterator();
        while (localIterator.hasNext())
        {
          SeeRoomMemberUI.a locala = (SeeRoomMemberUI.a)localIterator.next();
          if ((locala != null) && (locala.contact != null) && (locala.type == 1))
          {
            Object localObject = locala.contact;
            if ((((aw)localObject).field_conRemark != null) && (((aw)localObject).field_conRemark.toUpperCase().contains(paramString.toUpperCase())))
            {
              localArrayList.add(locala);
            }
            else if ((!bt.isNullOrNil(SeeRoomMemberUI.a(this.fLO, ((aw)localObject).field_username))) && (SeeRoomMemberUI.a(this.fLO, ((aw)localObject).field_username).contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((am)localObject).adu() != null) && (((am)localObject).adu().toUpperCase().contains(paramString.toUpperCase())))
            {
              localArrayList.add(locala);
            }
            else if ((((am)localObject).VD() != null) && (((am)localObject).VD().toUpperCase().contains(paramString.toUpperCase())))
            {
              localArrayList.add(locala);
            }
            else if ((((am)localObject).VA() != null) && (((am)localObject).VA().contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((aw)localObject).field_username != null) && (((aw)localObject).field_username.contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if (!com.tencent.mm.o.b.lM(((aw)localObject).field_type))
            {
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azq().aqz(((aw)localObject).field_username);
              if ((localObject != null) && (((cf)localObject).field_conRemark != null) && (((cf)localObject).field_conRemark.toUpperCase().contains(paramString.toUpperCase()))) {
                localArrayList.add(locala);
              }
            }
          }
        }
        ad.i("MicroMsg.SeeRoomMemberUI", "[setMemberListBySearch]");
      }
      for (this.dAa = localArrayList;; this.dAa = this.fSP)
      {
        notifyDataSetChanged();
        AppMethodBeat.o(12870);
        return;
      }
    }
    
    public final void S(List<String> paramList)
    {
      AppMethodBeat.i(12869);
      if (paramList == null)
      {
        AppMethodBeat.o(12869);
        return;
      }
      this.dAa.clear();
      int i = 0;
      if (i < paramList.size())
      {
        am localam = this.fSQ.azp().Bf((String)paramList.get(i));
        if (this.fLO.Az(localam.field_username)) {
          this.dAa.add(new SeeRoomMemberUI.a(localam, 3));
        }
        for (;;)
        {
          i += 1;
          break;
          if (this.fLO.aSH(localam.field_username)) {
            this.dAa.add(new SeeRoomMemberUI.a(localam, 2));
          } else {
            this.dAa.add(new SeeRoomMemberUI.a(localam, 1));
          }
        }
      }
      Collections.sort(this.dAa, new Comparator() {});
      this.dAa.add(new SeeRoomMemberUI.a(2));
      if (this.fLO.YH()) {
        this.dAa.add(new SeeRoomMemberUI.a(3));
      }
      this.fSP = this.dAa;
      notifyDataSetChanged();
      AppMethodBeat.o(12869);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(12874);
      int i = this.dAa.size();
      AppMethodBeat.o(12874);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(12872);
      View localView;
      SeeRoomMemberUI.c localc;
      String str;
      if (paramView == null)
      {
        localView = View.inflate(this.mContext, 2131495336, null);
        localc = new SeeRoomMemberUI.c((byte)0);
        localc.fSS = ((AvatarPatTipImageView)localView.findViewById(2131304481));
        localc.fPC = ((TextView)localView.findViewById(2131304483));
        paramView = (WindowManager)this.mContext.getSystemService("window");
        localc.fPC.setMaxWidth(paramView.getDefaultDisplay().getWidth() * 2 / 3);
        localc.fST = ((TextView)localView.findViewById(2131304484));
        localView.setTag(localc);
        localc.fSS.setTag(Integer.valueOf(paramInt));
        if (localc.fST != null) {
          localc.fST.setVisibility(8);
        }
        paramView = (SeeRoomMemberUI.a)this.dAa.get(paramInt);
        if ((paramView == null) || (paramView.type != 1)) {
          break label471;
        }
        am localam = paramView.contact;
        com.tencent.mm.pluginsdk.ui.a.b.c(localc.fSS, localam.field_username);
        str = SeeRoomMemberUI.a(this.fLO, localam.field_username);
        if (bt.isNullOrNil(localam.field_conRemark)) {
          break label444;
        }
        paramViewGroup = localam.field_conRemark;
        label228:
        paramView = paramViewGroup;
        if (bt.isNullOrNil(paramViewGroup)) {
          paramView = localam.adu();
        }
        paramViewGroup = paramView;
        if (str != null)
        {
          paramViewGroup = paramView;
          if (!str.equals(""))
          {
            paramViewGroup = paramView;
            if (!paramView.equals(str)) {
              paramViewGroup = str + "( " + paramView + " )";
            }
          }
        }
        localc.fPC.setVisibility(0);
        localc.fPC.setText(k.b(this.mContext, paramViewGroup, localc.fPC.getTextSize()));
        localc.fSS.setTagUsername(localam.field_username);
        localc.fSS.setTagTalker(this.roomId);
        localc.fSS.setTagScene(4);
        localc.fSS.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(213558);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SeeRoomMemberUI$ChatroomMemberAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if (paramAnonymousView.getTag() != null)
            {
              int i = ((Integer)paramAnonymousView.getTag()).intValue();
              SeeRoomMemberUI.k(SeeRoomMemberUI.this).onItemClick(SeeRoomMemberUI.b(SeeRoomMemberUI.this), paramAnonymousView, i, SeeRoomMemberUI.b.this.getItemId(i));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$ChatroomMemberAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(213558);
          }
        });
        if (localc.fST != null)
        {
          paramView = com.tencent.mm.openim.room.a.a.H(localam);
          if (!TextUtils.isEmpty(paramView)) {
            break label450;
          }
          localc.fST.setVisibility(8);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(12872);
        return localView;
        localc = (SeeRoomMemberUI.c)paramView.getTag();
        localView = paramView;
        break;
        label444:
        paramViewGroup = str;
        break label228;
        label450:
        localc.fST.setVisibility(0);
        localc.fST.setText(paramView);
        continue;
        label471:
        if ((paramView != null) && (paramView.type == 2))
        {
          localc.fPC.setVisibility(4);
          localc.fSS.setImageResource(2131231164);
          localc.fSS.setTagUsername("");
        }
        else if ((paramView != null) && (paramView.type == 3))
        {
          localc.fPC.setVisibility(4);
          localc.fSS.setImageResource(2131231165);
          localc.fSS.setTagUsername("");
        }
      }
    }
    
    public final SeeRoomMemberUI.a li(int paramInt)
    {
      AppMethodBeat.i(12871);
      SeeRoomMemberUI.a locala = (SeeRoomMemberUI.a)this.dAa.get(paramInt);
      AppMethodBeat.o(12871);
      return locala;
    }
    
    public final void vb(String paramString)
    {
      AppMethodBeat.i(12873);
      this.fSN = true;
      this.fSM = paramString;
      va(paramString);
      AppMethodBeat.o(12873);
    }
  }
  
  static final class c
  {
    public TextView fPC;
    public AvatarPatTipImageView fSS;
    public TextView fST;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomMemberUI
 * JD-Core Version:    0.7.0.1
 */