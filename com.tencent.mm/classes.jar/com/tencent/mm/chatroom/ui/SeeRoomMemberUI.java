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
import com.tencent.mm.ak.f;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.al;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.cb;
import com.tencent.mm.storage.cg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
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
  private static int fUM = 5;
  private boolean dzK;
  private com.tencent.mm.storage.ac fNS;
  private boolean fOE;
  private String fRo;
  private String fSH;
  private int fSI;
  private String fSJ;
  private boolean fSK;
  private p fSP;
  private b fUF;
  private String fUG;
  private String fUH;
  private com.tencent.mm.ui.tools.r fUI;
  private String fUJ;
  private MMEditText fUK;
  private int fUL;
  private AdapterView.OnItemClickListener fUN;
  private GridView fUo;
  private int fq;
  private String mTitle;
  private String talker;
  private String username;
  
  public SeeRoomMemberUI()
  {
    AppMethodBeat.i(217276);
    this.fUN = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(217271);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousAdapterView = SeeRoomMemberUI.c(SeeRoomMemberUI.this).lk(paramAnonymousInt);
        if (paramAnonymousAdapterView.type == 2)
        {
          ae.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Add member");
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(219L, 6L, 1L, true);
          SeeRoomMemberUI.f(SeeRoomMemberUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(217271);
          return;
        }
        if (paramAnonymousAdapterView.type == 3)
        {
          ae.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Delete member");
          SeeRoomMemberUI.g(SeeRoomMemberUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(217271);
          return;
        }
        if (paramAnonymousAdapterView.type == 1)
        {
          paramAnonymousAdapterView = SeeRoomMemberUI.c(SeeRoomMemberUI.this).lk(paramAnonymousInt).contact;
          if (paramAnonymousAdapterView == null)
          {
            ae.e("MicroMsg.SeeRoomMemberUI", "cont is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(217271);
            return;
          }
          SeeRoomMemberUI.a(SeeRoomMemberUI.this, paramAnonymousAdapterView.field_username);
          paramAnonymousView = paramAnonymousAdapterView.field_nickname;
          localObject = SeeRoomMemberUI.a(SeeRoomMemberUI.e(SeeRoomMemberUI.this), SeeRoomMemberUI.h(SeeRoomMemberUI.this));
          if (!bu.isNullOrNil((String)localObject)) {
            break label332;
          }
          SeeRoomMemberUI.b(SeeRoomMemberUI.this, paramAnonymousAdapterView.adG());
        }
        for (;;)
        {
          com.tencent.mm.ui.contact.ac.u(SeeRoomMemberUI.i(SeeRoomMemberUI.this).getText().toString(), 1, 6, paramAnonymousInt + 1);
          SeeRoomMemberUI.a(SeeRoomMemberUI.this, SeeRoomMemberUI.h(SeeRoomMemberUI.this), SeeRoomMemberUI.j(SeeRoomMemberUI.this), paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(217271);
          return;
          label332:
          SeeRoomMemberUI.b(SeeRoomMemberUI.this, (String)localObject);
        }
      }
    };
    AppMethodBeat.o(217276);
  }
  
  protected static String a(com.tencent.mm.storage.ac paramac, String paramString)
  {
    AppMethodBeat.i(12892);
    if (paramac == null)
    {
      AppMethodBeat.o(12892);
      return "";
    }
    paramac = paramac.zP(paramString);
    AppMethodBeat.o(12892);
    return paramac;
  }
  
  private static int bV(Context paramContext)
  {
    AppMethodBeat.i(12879);
    int i = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
    int j = (int)(paramContext.getResources().getDimension(2131165500) * 2.0F + paramContext.getResources().getDimension(2131165508));
    i = (int)((i - paramContext.getResources().getDimension(2131165489) * 1.0F) / j);
    ae.i("MicroMsg.SeeRoomMemberUI", "[getWrapColNum] :%s", new Object[] { Integer.valueOf(i) });
    fUM = i;
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
    //   80: invokestatic 553	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   105: invokestatic 553	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: goto -25 -> 83
    //   111: astore_0
    //   112: ldc 140
    //   114: aload_0
    //   115: ldc 112
    //   117: iconst_0
    //   118: anewarray 411	java/lang/Object
    //   121: invokestatic 553	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: aconst_null
    //   125: astore_0
    //   126: goto -66 -> 60
    //   129: astore_0
    //   130: ldc 140
    //   132: aload_0
    //   133: ldc 112
    //   135: iconst_0
    //   136: anewarray 411	java/lang/Object
    //   139: invokestatic 553	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: aconst_null
    //   143: astore_0
    //   144: goto -84 -> 60
    //   147: astore_0
    //   148: ldc 140
    //   150: aload_0
    //   151: ldc 112
    //   153: iconst_0
    //   154: anewarray 411	java/lang/Object
    //   157: invokestatic 553	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  private void vv(final String paramString)
  {
    AppMethodBeat.i(12884);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(12884);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramString);
    paramString = com.tencent.mm.roomsdk.a.b.aRc(this.fRo).a(this.fRo, localLinkedList, 0);
    paramString.b(new com.tencent.mm.roomsdk.a.b.b() {});
    paramString.c(new com.tencent.mm.roomsdk.a.b.b() {});
    getString(2131755906);
    paramString.a(this, getString(2131762595), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(217274);
        paramString.cancel();
        AppMethodBeat.o(217274);
      }
    });
    AppMethodBeat.o(12884);
  }
  
  public final void Yv()
  {
    AppMethodBeat.i(12881);
    al localal = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP();
    if (this.talker == null) {}
    for (String str = this.fRo;; str = this.talker)
    {
      this.fNS = localal.Bx(str);
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(217272);
          if (SeeRoomMemberUI.c(SeeRoomMemberUI.this) != null) {
            SeeRoomMemberUI.c(SeeRoomMemberUI.this).S(this.fUQ);
          }
          AppMethodBeat.o(217272);
        }
      });
      AppMethodBeat.o(12881);
      return;
    }
  }
  
  public final void Yw()
  {
    AppMethodBeat.i(217277);
    if (this.fNS != null) {
      setMMTitle(this.mTitle + "(" + this.fNS.aGE().size() + ")");
    }
    AppMethodBeat.o(217277);
  }
  
  public int getLayoutId()
  {
    return 2131495337;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12880);
    setMMTitle(this.mTitle + "(" + this.fSI + ")");
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
    this.fUK = ((MMEditText)findViewById(2131302626));
    this.fUo = ((GridView)findViewById(2131297966));
    this.fUo.setNumColumns(bV(this));
    this.fUo.setColumnWidth(getResources().getDimensionPixelSize(2131165489));
    com.tencent.mm.storage.ac localac = this.fNS;
    String str = this.fRo;
    Object localObject = new LinkedList();
    if (!bu.isNullOrNil(this.fUG)) {
      localObject = bu.U(this.fUG.split(","));
    }
    cb localcb = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azO().arD("@t.qq.com");
    if (localcb != null) {
      ((List)localObject).add(localcb.name);
    }
    this.fUF = new b(this, localac, str, (List)localObject, this.fSJ);
    this.fUK.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(12860);
        SeeRoomMemberUI.c(SeeRoomMemberUI.this).vx(paramAnonymousCharSequence.toString());
        AppMethodBeat.o(12860);
      }
    });
    this.fUo.setOnItemClickListener(this.fUN);
    this.fUo.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(217270);
        if (SeeRoomMemberUI.d(SeeRoomMemberUI.this))
        {
          paramAnonymousAdapterView = SeeRoomMemberUI.c(SeeRoomMemberUI.this).lk(paramAnonymousInt).contact;
          if (paramAnonymousAdapterView == null)
          {
            AppMethodBeat.o(217270);
            return true;
          }
          paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
          if (SeeRoomMemberUI.e(SeeRoomMemberUI.this).field_roomowner.equals(paramAnonymousAdapterView))
          {
            AppMethodBeat.o(217270);
            return true;
          }
          h.a(SeeRoomMemberUI.this, SeeRoomMemberUI.this.getString(2131762597), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(217269);
              SeeRoomMemberUI.a(SeeRoomMemberUI.this, paramAnonymousInt);
              AppMethodBeat.o(217269);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          });
        }
        for (;;)
        {
          AppMethodBeat.o(217270);
          return true;
          ae.i("MicroMsg.SeeRoomMemberUI", "U are not a roomowner");
        }
      }
    });
    this.fUo.setAdapter(this.fUF);
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
      if ((x.zU(this.fRo)) && (!x.zX(this.fRo)) && (!com.tencent.mm.model.q.zo(str)))
      {
        h.c(this, getString(2131762644), getString(2131755906), true);
        AppMethodBeat.o(12886);
        return;
      }
      if (bu.nullAsNil(v.aAC()).equals(str)) {
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
          Object localObject = com.tencent.mm.model.r.zA(this.fRo);
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
      if (bu.U(str.split(",")) == null)
      {
        AppMethodBeat.o(12886);
        return;
      }
      str = paramIntent.getStringExtra("Select_Contact");
      long l = paramIntent.getLongExtra("select_record_fake_msg_id", 0L);
      new com.tencent.mm.chatroom.g.a(this, this.fRo, str, localLocalHistoryInfo, l, this);
      AppMethodBeat.o(12886);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(12886);
        return;
      }
      vv(paramIntent.getStringExtra("Select_Contact"));
      break;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(12878);
    super.onConfigurationChanged(paramConfiguration);
    this.fUo.setNumColumns(bV(this));
    AppMethodBeat.o(12878);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12876);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(219L, 2L, 1L, true);
    com.tencent.mm.kernel.g.ajQ().gDv.a(990, this);
    this.fRo = getIntent().getStringExtra("RoomInfo_Id");
    this.talker = getIntent().getStringExtra("Chat_User");
    this.fUH = getIntent().getStringExtra("Chatroom_member_list");
    this.dzK = getIntent().getBooleanExtra("Is_Chatroom", true);
    this.fOE = getIntent().getBooleanExtra("Is_Lbsroom", false);
    this.fSK = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.fSJ = getIntent().getStringExtra("room_owner_name");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    al localal = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP();
    if (this.talker == null)
    {
      paramBundle = this.fRo;
      this.fNS = localal.Bx(paramBundle);
      this.fSI = getIntent().getIntExtra("room_member_count", 0);
      this.fSH = getIntent().getStringExtra("room_name");
      this.fq = getIntent().getIntExtra("offset", 0);
      this.fUL = getIntent().getIntExtra("first_pos", 0);
      initView();
      if (this.fUF != null)
      {
        Yv();
        paramBundle = this.fUo;
        if (this.fUL * fUM >= this.fUF.getCount()) {
          break label336;
        }
      }
    }
    label336:
    for (int i = this.fUL * fUM;; i = this.fUF.getCount() - 1)
    {
      paramBundle.setSelection(i);
      this.fUo.postDelayed(new Runnable()
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
    com.tencent.mm.kernel.g.ajQ().gDv.b(990, this);
    if ((this.fSP != null) && (this.fSP.isShowing())) {
      this.fSP.dismiss();
    }
    super.onDestroy();
    AppMethodBeat.o(12883);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(12882);
    super.onPause();
    if (this.fUI != null) {
      this.fUI.fOV();
    }
    AppMethodBeat.o(12882);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12877);
    super.onResume();
    if (this.fUF != null) {
      this.fUF.vx(this.fUK.getText().toString());
    }
    AppMethodBeat.o(12877);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(12885);
    if ((this.fSP != null) && (this.fSP.isShowing())) {
      this.fSP.dismiss();
    }
    paramString = com.tencent.mm.h.a.uU(paramString);
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
    an contact;
    int order = 0;
    int type;
    
    public a(int paramInt)
    {
      this.type = paramInt;
      this.contact = null;
    }
    
    public a(an paraman, int paramInt)
    {
      this.type = 1;
      this.contact = paraman;
      this.order = paramInt;
    }
  }
  
  final class b
    extends BaseAdapter
  {
    private List<SeeRoomMemberUI.a> dBf;
    private com.tencent.mm.storage.ac fNS;
    private List<String> fUR;
    public String fUS;
    private boolean fUT;
    private String fUU;
    private List<SeeRoomMemberUI.a> fUV;
    private com.tencent.mm.plugin.messenger.foundation.a.l fUW;
    private Context mContext;
    private String roomId;
    
    public b(com.tencent.mm.storage.ac paramac, String paramString1, List<String> paramList, String paramString2)
    {
      AppMethodBeat.i(12868);
      this.fUT = false;
      this.fUU = null;
      this.dBf = new ArrayList();
      this.fNS = paramString1;
      this.roomId = paramList;
      this.fUR = paramString2;
      Object localObject;
      this.fUU = localObject;
      this.mContext = paramac;
      this.fUW = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class));
      S(com.tencent.mm.model.r.zA(paramList));
      AppMethodBeat.o(12868);
    }
    
    private void vw(String paramString)
    {
      AppMethodBeat.i(12870);
      ArrayList localArrayList = new ArrayList();
      if (!bu.isNullOrNil(paramString))
      {
        Iterator localIterator = this.fUV.iterator();
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
            else if ((!bu.isNullOrNil(SeeRoomMemberUI.a(this.fNS, ((aw)localObject).field_username))) && (SeeRoomMemberUI.a(this.fNS, ((aw)localObject).field_username).contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((an)localObject).adF() != null) && (((an)localObject).adF().toUpperCase().contains(paramString.toUpperCase())))
            {
              localArrayList.add(locala);
            }
            else if ((((an)localObject).VL() != null) && (((an)localObject).VL().toUpperCase().contains(paramString.toUpperCase())))
            {
              localArrayList.add(locala);
            }
            else if ((((an)localObject).VI() != null) && (((an)localObject).VI().contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((aw)localObject).field_username != null) && (((aw)localObject).field_username.contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if (!com.tencent.mm.contact.c.lO(((aw)localObject).field_type))
            {
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azG().arE(((aw)localObject).field_username);
              if ((localObject != null) && (((cg)localObject).field_conRemark != null) && (((cg)localObject).field_conRemark.toUpperCase().contains(paramString.toUpperCase()))) {
                localArrayList.add(locala);
              }
            }
          }
        }
        ae.i("MicroMsg.SeeRoomMemberUI", "[setMemberListBySearch]");
      }
      for (this.dBf = localArrayList;; this.dBf = this.fUV)
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
      this.dBf.clear();
      int i = 0;
      if (i < paramList.size())
      {
        an localan = this.fUW.azF().BH((String)paramList.get(i));
        if (this.fNS.Bj(localan.field_username)) {
          this.dBf.add(new SeeRoomMemberUI.a(localan, 3));
        }
        for (;;)
        {
          i += 1;
          break;
          if (this.fNS.aUg(localan.field_username)) {
            this.dBf.add(new SeeRoomMemberUI.a(localan, 2));
          } else {
            this.dBf.add(new SeeRoomMemberUI.a(localan, 1));
          }
        }
      }
      Collections.sort(this.dBf, new Comparator() {});
      this.dBf.add(new SeeRoomMemberUI.a(2));
      if (this.fNS.YQ()) {
        this.dBf.add(new SeeRoomMemberUI.a(3));
      }
      this.fUV = this.dBf;
      notifyDataSetChanged();
      AppMethodBeat.o(12869);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(12874);
      int i = this.dBf.size();
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
        localc.fUY = ((AvatarPatTipImageView)localView.findViewById(2131304481));
        localc.fRI = ((TextView)localView.findViewById(2131304483));
        paramView = (WindowManager)this.mContext.getSystemService("window");
        localc.fRI.setMaxWidth(paramView.getDefaultDisplay().getWidth() * 2 / 3);
        localc.fUZ = ((TextView)localView.findViewById(2131304484));
        localView.setTag(localc);
        localc.fUY.setTag(Integer.valueOf(paramInt));
        if (localc.fUZ != null) {
          localc.fUZ.setVisibility(8);
        }
        paramView = (SeeRoomMemberUI.a)this.dBf.get(paramInt);
        if ((paramView == null) || (paramView.type != 1)) {
          break label471;
        }
        an localan = paramView.contact;
        com.tencent.mm.pluginsdk.ui.a.b.c(localc.fUY, localan.field_username);
        str = SeeRoomMemberUI.a(this.fNS, localan.field_username);
        if (bu.isNullOrNil(localan.field_conRemark)) {
          break label444;
        }
        paramViewGroup = localan.field_conRemark;
        label228:
        paramView = paramViewGroup;
        if (bu.isNullOrNil(paramViewGroup)) {
          paramView = localan.adF();
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
        localc.fRI.setVisibility(0);
        localc.fRI.setText(k.b(this.mContext, paramViewGroup, localc.fRI.getTextSize()));
        localc.fUY.setTagUsername(localan.field_username);
        localc.fUY.setTagTalker(this.roomId);
        localc.fUY.setTagScene(4);
        localc.fUY.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(217275);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SeeRoomMemberUI$ChatroomMemberAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (paramAnonymousView.getTag() != null)
            {
              int i = ((Integer)paramAnonymousView.getTag()).intValue();
              SeeRoomMemberUI.k(SeeRoomMemberUI.this).onItemClick(SeeRoomMemberUI.b(SeeRoomMemberUI.this), paramAnonymousView, i, SeeRoomMemberUI.b.this.getItemId(i));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$ChatroomMemberAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(217275);
          }
        });
        if (localc.fUZ != null)
        {
          paramView = com.tencent.mm.openim.room.a.a.O(localan);
          if (!TextUtils.isEmpty(paramView)) {
            break label450;
          }
          localc.fUZ.setVisibility(8);
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
        localc.fUZ.setVisibility(0);
        localc.fUZ.setText(paramView);
        continue;
        label471:
        if ((paramView != null) && (paramView.type == 2))
        {
          localc.fRI.setVisibility(4);
          localc.fUY.setImageResource(2131231164);
          localc.fUY.setTagUsername("");
        }
        else if ((paramView != null) && (paramView.type == 3))
        {
          localc.fRI.setVisibility(4);
          localc.fUY.setImageResource(2131231165);
          localc.fUY.setTagUsername("");
        }
      }
    }
    
    public final SeeRoomMemberUI.a lk(int paramInt)
    {
      AppMethodBeat.i(12871);
      SeeRoomMemberUI.a locala = (SeeRoomMemberUI.a)this.dBf.get(paramInt);
      AppMethodBeat.o(12871);
      return locala;
    }
    
    public final void vx(String paramString)
    {
      AppMethodBeat.i(12873);
      this.fUT = true;
      this.fUS = paramString;
      vw(paramString);
      AppMethodBeat.o(12873);
    }
  }
  
  static final class c
  {
    public TextView fRI;
    public AvatarPatTipImageView fUY;
    public TextView fUZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomMemberUI
 * JD-Core Version:    0.7.0.1
 */