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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.cj;
import com.tencent.mm.storage.co;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.contact.ae;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SeeRoomMemberUI
  extends MMActivity
  implements i, com.tencent.mm.chatroom.g.a.b
{
  private static int jjW = 5;
  private boolean fKN;
  private boolean iXZ;
  private ah iXp;
  private String jaK;
  private String jhR;
  private int jhS;
  private String jhT;
  private boolean jhU;
  private s jhZ;
  private b jjP;
  private String jjQ;
  private String jjR;
  private com.tencent.mm.ui.tools.t jjS;
  private String jjT;
  private MMEditText jjU;
  private int jjV;
  private AdapterView.OnItemClickListener jjX;
  private GridView jjy;
  private String mTitle;
  private String talker;
  private String username;
  private int zP;
  
  public SeeRoomMemberUI()
  {
    AppMethodBeat.i(188658);
    this.jjX = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(190533);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if (paramAnonymousInt > SeeRoomMemberUI.c(SeeRoomMemberUI.this).getCount() - 1)
        {
          Log.i("MicroMsg.SeeRoomMemberUI", "[onItemClick]count=%s position=%s", new Object[] { Integer.valueOf(SeeRoomMemberUI.c(SeeRoomMemberUI.this).getCount()), Integer.valueOf(paramAnonymousInt) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(190533);
          return;
        }
        paramAnonymousAdapterView = SeeRoomMemberUI.c(SeeRoomMemberUI.this).qB(paramAnonymousInt);
        if (paramAnonymousAdapterView.type == 2)
        {
          Log.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Add member");
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(219L, 6L, 1L, true);
          SeeRoomMemberUI.f(SeeRoomMemberUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(190533);
          return;
        }
        if (paramAnonymousAdapterView.type == 3)
        {
          Log.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Delete member");
          SeeRoomMemberUI.g(SeeRoomMemberUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(190533);
          return;
        }
        if (paramAnonymousAdapterView.type == 1)
        {
          paramAnonymousAdapterView = SeeRoomMemberUI.c(SeeRoomMemberUI.this).qB(paramAnonymousInt).contact;
          if (paramAnonymousAdapterView == null)
          {
            Log.e("MicroMsg.SeeRoomMemberUI", "cont is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(190533);
            return;
          }
          SeeRoomMemberUI.a(SeeRoomMemberUI.this, paramAnonymousAdapterView.field_username);
          paramAnonymousView = paramAnonymousAdapterView.field_nickname;
          localObject = SeeRoomMemberUI.a(SeeRoomMemberUI.e(SeeRoomMemberUI.this), SeeRoomMemberUI.h(SeeRoomMemberUI.this));
          if (!Util.isNullOrNil((String)localObject)) {
            break label400;
          }
          SeeRoomMemberUI.b(SeeRoomMemberUI.this, paramAnonymousAdapterView.ays());
        }
        for (;;)
        {
          ae.y(SeeRoomMemberUI.i(SeeRoomMemberUI.this).getText().toString(), 1, 6, paramAnonymousInt + 1);
          SeeRoomMemberUI.a(SeeRoomMemberUI.this, SeeRoomMemberUI.h(SeeRoomMemberUI.this), SeeRoomMemberUI.j(SeeRoomMemberUI.this), paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(190533);
          return;
          label400:
          SeeRoomMemberUI.b(SeeRoomMemberUI.this, (String)localObject);
        }
      }
    };
    AppMethodBeat.o(188658);
  }
  
  private void KE(final String paramString)
  {
    AppMethodBeat.i(12884);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(12884);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramString);
    paramString = com.tencent.mm.roomsdk.a.b.btX(this.jaK).a(this.jaK, localLinkedList, 0);
    paramString.b(new com.tencent.mm.roomsdk.a.b.b() {});
    paramString.c(new com.tencent.mm.roomsdk.a.b.b() {});
    paramString.a(this, getString(a.i.app_tip), getString(a.i.eQQ), true, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(194109);
        paramString.cancel();
        AppMethodBeat.o(194109);
      }
    });
    AppMethodBeat.o(12884);
  }
  
  protected static String a(ah paramah, String paramString)
  {
    AppMethodBeat.i(12892);
    if (paramah == null)
    {
      AppMethodBeat.o(12892);
      return "";
    }
    paramah = paramah.PJ(paramString);
    AppMethodBeat.o(12892);
    return paramah;
  }
  
  private static int cm(Context paramContext)
  {
    AppMethodBeat.i(12879);
    int i = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
    int j = (int)(paramContext.getResources().getDimension(a.c.MiddlePadding) * 2.0F + paramContext.getResources().getDimension(a.c.NormalAvatarSize));
    i = (int)((i - paramContext.getResources().getDimension(a.c.ListPadding) * 1.0F) / j);
    Log.i("MicroMsg.SeeRoomMemberUI", "[getWrapColNum] :%s", new Object[] { Integer.valueOf(i) });
    jjW = i;
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
    //   19: invokevirtual 584	java/lang/Object:getClass	()Ljava/lang/Class;
    //   22: astore 4
    //   24: aload 4
    //   26: ldc_w 467
    //   29: if_acmpeq +136 -> 165
    //   32: aload 4
    //   34: aload_1
    //   35: aload_3
    //   36: invokevirtual 590	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   39: astore 5
    //   41: aload 5
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +115 -> 160
    //   48: aload_1
    //   49: iconst_1
    //   50: invokevirtual 596	java/lang/reflect/Method:setAccessible	(Z)V
    //   53: aload_1
    //   54: aload_0
    //   55: aload_2
    //   56: invokevirtual 600	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   59: astore_0
    //   60: sipush 12893
    //   63: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_0
    //   67: areturn
    //   68: astore 5
    //   70: ldc 196
    //   72: aload 5
    //   74: ldc 103
    //   76: iconst_0
    //   77: anewarray 467	java/lang/Object
    //   80: invokestatic 604	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aload 4
    //   85: invokevirtual 607	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   88: astore 4
    //   90: goto -66 -> 24
    //   93: astore 5
    //   95: ldc 196
    //   97: aload 5
    //   99: ldc 103
    //   101: iconst_0
    //   102: anewarray 467	java/lang/Object
    //   105: invokestatic 604	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: goto -25 -> 83
    //   111: astore_0
    //   112: ldc 196
    //   114: aload_0
    //   115: ldc 103
    //   117: iconst_0
    //   118: anewarray 467	java/lang/Object
    //   121: invokestatic 604	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: aconst_null
    //   125: astore_0
    //   126: goto -66 -> 60
    //   129: astore_0
    //   130: ldc 196
    //   132: aload_0
    //   133: ldc 103
    //   135: iconst_0
    //   136: anewarray 467	java/lang/Object
    //   139: invokestatic 604	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: aconst_null
    //   143: astore_0
    //   144: goto -84 -> 60
    //   147: astore_0
    //   148: ldc 196
    //   150: aload_0
    //   151: ldc 103
    //   153: iconst_0
    //   154: anewarray 467	java/lang/Object
    //   157: invokestatic 604	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public final void asj()
  {
    AppMethodBeat.i(12881);
    aq localaq = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV();
    if (this.talker == null) {}
    for (String str = this.jaK;; str = this.talker)
    {
      this.iXp = localaq.Rw(str);
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186687);
          if (SeeRoomMemberUI.c(SeeRoomMemberUI.this) != null) {
            SeeRoomMemberUI.c(SeeRoomMemberUI.this).V(this.jka);
          }
          AppMethodBeat.o(186687);
        }
      });
      AppMethodBeat.o(12881);
      return;
    }
  }
  
  public final void ask()
  {
    AppMethodBeat.i(188689);
    if (this.iXp != null) {
      setMMTitle(this.mTitle + "(" + this.iXp.bjL().size() + ")");
    }
    AppMethodBeat.o(188689);
  }
  
  public int getLayoutId()
  {
    return a.f.jen;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12880);
    setMMTitle(this.mTitle + "(" + this.jhS + ")");
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
    this.jjU = ((MMEditText)findViewById(a.e.mutiselectcontact_edittext));
    this.jjy = ((GridView)findViewById(a.e.jcv));
    this.jjy.setNumColumns(cm(this));
    this.jjy.setColumnWidth(getResources().getDimensionPixelSize(a.c.ListPadding));
    ah localah = this.iXp;
    String str = this.jaK;
    Object localObject = new LinkedList();
    if (!Util.isNullOrNil(this.jjQ)) {
      localObject = Util.stringsToList(this.jjQ.split(","));
    }
    cj localcj = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbU().aPi("@t.qq.com");
    if (localcj != null) {
      ((List)localObject).add(localcj.name);
    }
    this.jjP = new b(this, localah, str, (List)localObject, this.jhT);
    this.jjU.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(12860);
        SeeRoomMemberUI.c(SeeRoomMemberUI.this).KG(paramAnonymousCharSequence.toString());
        AppMethodBeat.o(12860);
      }
    });
    this.jjy.setOnItemClickListener(this.jjX);
    this.jjy.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(186882);
        if (SeeRoomMemberUI.d(SeeRoomMemberUI.this))
        {
          paramAnonymousAdapterView = SeeRoomMemberUI.c(SeeRoomMemberUI.this).qB(paramAnonymousInt).contact;
          if (paramAnonymousAdapterView == null)
          {
            AppMethodBeat.o(186882);
            return true;
          }
          paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
          if (SeeRoomMemberUI.e(SeeRoomMemberUI.this).field_roomowner.equals(paramAnonymousAdapterView))
          {
            AppMethodBeat.o(186882);
            return true;
          }
          com.tencent.mm.ui.base.h.a(SeeRoomMemberUI.this, SeeRoomMemberUI.this.getString(a.i.jfV), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(187887);
              SeeRoomMemberUI.a(SeeRoomMemberUI.this, paramAnonymousInt);
              AppMethodBeat.o(187887);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          });
        }
        for (;;)
        {
          AppMethodBeat.o(186882);
          return true;
          Log.i("MicroMsg.SeeRoomMemberUI", "U are not a roomowner");
        }
      }
    });
    this.jjy.setAdapter(this.jjP);
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
      if ((ab.PP(this.jaK)) && (!ab.PT(this.jaK)) && (!u.Pg(str)))
      {
        com.tencent.mm.ui.base.h.c(this, getString(a.i.jgm), getString(a.i.app_tip), true);
        AppMethodBeat.o(12886);
        return;
      }
      if (Util.nullAsNil(z.bcZ()).equals(str)) {
        paramInt1 = 1;
      }
      for (;;)
      {
        label150:
        if (paramInt1 != 0)
        {
          com.tencent.mm.ui.base.h.c(this, getString(a.i.add_room_mem_memberExits), getString(a.i.app_tip), true);
          AppMethodBeat.o(12886);
          return;
          Object localObject = v.Ps(this.jaK);
          paramInt1 = i;
          if (localObject != null)
          {
            localObject = ((List)localObject).iterator();
            paramInt1 = 0;
            label209:
            if (((Iterator)localObject).hasNext())
            {
              if (!((String)((Iterator)localObject).next()).equals(str)) {
                break label337;
              }
              paramInt1 = 1;
            }
          }
        }
      }
    }
    label337:
    for (;;)
    {
      break label209;
      break label150;
      if (Util.stringsToList(str.split(",")) == null)
      {
        AppMethodBeat.o(12886);
        return;
      }
      str = paramIntent.getStringExtra("Select_Contact");
      long l = paramIntent.getLongExtra("select_record_fake_msg_id", 0L);
      new com.tencent.mm.chatroom.g.a(this, this.jaK, str, localLocalHistoryInfo, l, this);
      AppMethodBeat.o(12886);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(12886);
        return;
      }
      KE(paramIntent.getStringExtra("Select_Contact"));
      break;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(12878);
    super.onConfigurationChanged(paramConfiguration);
    this.jjy.setNumColumns(cm(this));
    AppMethodBeat.o(12878);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12876);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(219L, 2L, 1L, true);
    com.tencent.mm.kernel.h.aHF().kcd.a(990, this);
    this.jaK = getIntent().getStringExtra("RoomInfo_Id");
    this.talker = getIntent().getStringExtra("Chat_User");
    this.jjR = getIntent().getStringExtra("Chatroom_member_list");
    this.fKN = getIntent().getBooleanExtra("Is_Chatroom", true);
    this.iXZ = getIntent().getBooleanExtra("Is_Lbsroom", false);
    this.jhU = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.jhT = getIntent().getStringExtra("room_owner_name");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    aq localaq = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV();
    if (this.talker == null)
    {
      paramBundle = this.jaK;
      this.iXp = localaq.Rw(paramBundle);
      this.jhS = getIntent().getIntExtra("room_member_count", 0);
      this.jhR = getIntent().getStringExtra("room_name");
      this.zP = getIntent().getIntExtra("offset", 0);
      this.jjV = getIntent().getIntExtra("first_pos", 0);
      initView();
      if (this.jjP != null)
      {
        asj();
        paramBundle = this.jjy;
        if (this.jjV * jjW >= this.jjP.getCount()) {
          break label336;
        }
      }
    }
    label336:
    for (int i = this.jjV * jjW;; i = this.jjP.getCount() - 1)
    {
      paramBundle.setSelection(i);
      this.jjy.postDelayed(new Runnable()
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
    com.tencent.mm.kernel.h.aHF().kcd.b(990, this);
    if ((this.jhZ != null) && (this.jhZ.isShowing())) {
      this.jhZ.dismiss();
    }
    super.onDestroy();
    AppMethodBeat.o(12883);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(12882);
    super.onPause();
    if (this.jjS != null) {
      this.jjS.hVb();
    }
    AppMethodBeat.o(12882);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12877);
    super.onResume();
    if (this.jjP != null) {
      this.jjP.KG(this.jjU.getText().toString());
    }
    AppMethodBeat.o(12877);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(12885);
    if ((this.jhZ != null) && (this.jhZ.isShowing())) {
      this.jhZ.dismiss();
    }
    paramString = com.tencent.mm.h.a.Kb(paramString);
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
    as contact;
    int order = 0;
    int type;
    
    public a(int paramInt)
    {
      this.type = paramInt;
      this.contact = null;
    }
    
    public a(as paramas, int paramInt)
    {
      this.type = 1;
      this.contact = paramas;
      this.order = paramInt;
    }
  }
  
  final class b
    extends BaseAdapter
  {
    private List<SeeRoomMemberUI.a> fMr;
    private ah iXp;
    private List<String> jkb;
    public String jkc;
    private boolean jkd;
    private String jke;
    private List<SeeRoomMemberUI.a> jkf;
    private com.tencent.mm.plugin.messenger.foundation.a.n jkg;
    private Context mContext;
    private String roomId;
    
    public b(ah paramah, String paramString1, List<String> paramList, String paramString2)
    {
      AppMethodBeat.i(12868);
      this.jkd = false;
      this.jke = null;
      this.fMr = new ArrayList();
      this.iXp = paramString1;
      this.roomId = paramList;
      this.jkb = paramString2;
      Object localObject;
      this.jke = localObject;
      this.mContext = paramah;
      this.jkg = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class));
      V(v.Ps(paramList));
      AppMethodBeat.o(12868);
    }
    
    private void KF(String paramString)
    {
      AppMethodBeat.i(12870);
      ArrayList localArrayList = new ArrayList();
      if (!Util.isNullOrNil(paramString))
      {
        Iterator localIterator = this.jkf.iterator();
        while (localIterator.hasNext())
        {
          SeeRoomMemberUI.a locala = (SeeRoomMemberUI.a)localIterator.next();
          if ((locala != null) && (locala.contact != null) && (locala.type == 1))
          {
            Object localObject = locala.contact;
            if ((((ax)localObject).field_conRemark != null) && (((ax)localObject).field_conRemark.toUpperCase().contains(paramString.toUpperCase())))
            {
              localArrayList.add(locala);
            }
            else if ((!Util.isNullOrNil(SeeRoomMemberUI.a(this.iXp, ((ax)localObject).field_username))) && (SeeRoomMemberUI.a(this.iXp, ((ax)localObject).field_username).contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((as)localObject).ayr() != null) && (((as)localObject).ayr().toUpperCase().contains(paramString.toUpperCase())))
            {
              localArrayList.add(locala);
            }
            else if ((((as)localObject).aph() != null) && (((as)localObject).aph().toUpperCase().contains(paramString.toUpperCase())))
            {
              localArrayList.add(locala);
            }
            else if ((((as)localObject).apf() != null) && (((as)localObject).apf().contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((ax)localObject).field_username != null) && (((ax)localObject).field_username.contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if (!d.rk(((ax)localObject).field_type))
            {
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbM().aPj(((ax)localObject).field_username);
              if ((localObject != null) && (((co)localObject).field_conRemark != null) && (((co)localObject).field_conRemark.toUpperCase().contains(paramString.toUpperCase()))) {
                localArrayList.add(locala);
              }
            }
          }
        }
        Log.i("MicroMsg.SeeRoomMemberUI", "[setMemberListBySearch]");
      }
      for (this.fMr = localArrayList;; this.fMr = this.jkf)
      {
        notifyDataSetChanged();
        AppMethodBeat.o(12870);
        return;
      }
    }
    
    public final void KG(String paramString)
    {
      AppMethodBeat.i(12873);
      this.jkd = true;
      this.jkc = paramString;
      KF(paramString);
      AppMethodBeat.o(12873);
    }
    
    public final void V(List<String> paramList)
    {
      AppMethodBeat.i(12869);
      if (paramList == null)
      {
        AppMethodBeat.o(12869);
        return;
      }
      this.fMr.clear();
      int i = 0;
      if (i < paramList.size())
      {
        as localas = this.jkg.bbL().RG((String)paramList.get(i));
        if (this.iXp.Rh(localas.field_username)) {
          this.fMr.add(new SeeRoomMemberUI.a(localas, 3));
        }
        for (;;)
        {
          i += 1;
          break;
          if (this.iXp.bvA(localas.field_username)) {
            this.fMr.add(new SeeRoomMemberUI.a(localas, 2));
          } else {
            this.fMr.add(new SeeRoomMemberUI.a(localas, 1));
          }
        }
      }
      Collections.sort(this.fMr, new Comparator() {});
      this.fMr.add(new SeeRoomMemberUI.a(2));
      if (this.iXp.asE()) {
        this.fMr.add(new SeeRoomMemberUI.a(3));
      }
      this.jkf = this.fMr;
      notifyDataSetChanged();
      AppMethodBeat.o(12869);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(12874);
      int i = this.fMr.size();
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
        localView = View.inflate(this.mContext, a.f.jem, null);
        localc = new SeeRoomMemberUI.c((byte)0);
        localc.jki = ((AvatarPatTipImageView)localView.findViewById(a.e.see_roommember_avatar));
        localc.jbe = ((TextView)localView.findViewById(a.e.see_roommember_name));
        paramView = (WindowManager)this.mContext.getSystemService("window");
        localc.jbe.setMaxWidth(paramView.getDefaultDisplay().getWidth() * 2 / 3);
        localc.jkj = ((TextView)localView.findViewById(a.e.see_roommember_name_sub_detail));
        localView.setTag(localc);
        localc.jki.setTag(Integer.valueOf(paramInt));
        if (localc.jkj != null) {
          localc.jkj.setVisibility(8);
        }
        paramView = (SeeRoomMemberUI.a)this.fMr.get(paramInt);
        if ((paramView == null) || (paramView.type != 1)) {
          break label472;
        }
        as localas = paramView.contact;
        com.tencent.mm.pluginsdk.ui.a.b.c(localc.jki, localas.field_username);
        str = SeeRoomMemberUI.a(this.iXp, localas.field_username);
        if (Util.isNullOrNil(localas.field_conRemark)) {
          break label445;
        }
        paramViewGroup = localas.field_conRemark;
        label229:
        paramView = paramViewGroup;
        if (Util.isNullOrNil(paramViewGroup)) {
          paramView = localas.ayr();
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
        localc.jbe.setVisibility(0);
        localc.jbe.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, paramViewGroup, localc.jbe.getTextSize()));
        localc.jki.setTagUsername(localas.field_username);
        localc.jki.setTagTalker(this.roomId);
        localc.jki.setTagScene(4);
        localc.jki.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(194017);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/SeeRoomMemberUI$ChatroomMemberAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            Log.i("MicroMsg.SeeRoomMemberUI", "onItemClick %s%s", new Object[] { paramAnonymousView, paramAnonymousView.getTag() });
            if (paramAnonymousView.getTag() != null)
            {
              int i = ((Integer)paramAnonymousView.getTag()).intValue();
              SeeRoomMemberUI.k(SeeRoomMemberUI.this).onItemClick(SeeRoomMemberUI.b(SeeRoomMemberUI.this), paramAnonymousView, i, SeeRoomMemberUI.b.this.getItemId(i));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$ChatroomMemberAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(194017);
          }
        });
        if (localc.jkj != null)
        {
          paramView = com.tencent.mm.openim.room.a.a.V(localas);
          if (!TextUtils.isEmpty(paramView)) {
            break label451;
          }
          localc.jkj.setVisibility(8);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(12872);
        return localView;
        localc = (SeeRoomMemberUI.c)paramView.getTag();
        localView = paramView;
        break;
        label445:
        paramViewGroup = str;
        break label229;
        label451:
        localc.jkj.setVisibility(0);
        localc.jkj.setText(paramView);
        continue;
        label472:
        if ((paramView != null) && (paramView.type == 2))
        {
          localc.jbe.setVisibility(4);
          localc.jki.setImageResource(a.d.big_add_selector);
          localc.jki.setTagUsername("");
        }
        else if ((paramView != null) && (paramView.type == 3))
        {
          localc.jbe.setVisibility(4);
          localc.jki.setImageResource(a.d.big_del_selector);
          localc.jki.setTagUsername("");
        }
      }
    }
    
    public final SeeRoomMemberUI.a qB(int paramInt)
    {
      AppMethodBeat.i(12871);
      SeeRoomMemberUI.a locala = (SeeRoomMemberUI.a)this.fMr.get(paramInt);
      AppMethodBeat.o(12871);
      return locala;
    }
  }
  
  static final class c
  {
    public TextView jbe;
    public AvatarPatTipImageView jki;
    public TextView jkj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomMemberUI
 * JD-Core Version:    0.7.0.1
 */