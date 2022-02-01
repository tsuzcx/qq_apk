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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ci;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.contact.ac;
import com.tencent.mm.ui.tools.s;
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
  private static int gzT = 5;
  private boolean dRx;
  private int fs;
  private boolean gtO;
  private ah gtd;
  private String gwx;
  private String gxP;
  private int gxQ;
  private String gxR;
  private boolean gxS;
  private com.tencent.mm.ui.base.q gxX;
  private b gzM;
  private String gzN;
  private String gzO;
  private s gzP;
  private String gzQ;
  private MMEditText gzR;
  private int gzS;
  private AdapterView.OnItemClickListener gzU;
  private GridView gzv;
  private String mTitle;
  private String talker;
  private String username;
  
  public SeeRoomMemberUI()
  {
    AppMethodBeat.i(194188);
    this.gzU = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(194183);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if (paramAnonymousInt > SeeRoomMemberUI.c(SeeRoomMemberUI.this).getCount() - 1)
        {
          Log.i("MicroMsg.SeeRoomMemberUI", "[onItemClick]count=%s position=%s", new Object[] { Integer.valueOf(SeeRoomMemberUI.c(SeeRoomMemberUI.this).getCount()), Integer.valueOf(paramAnonymousInt) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(194183);
          return;
        }
        paramAnonymousAdapterView = SeeRoomMemberUI.c(SeeRoomMemberUI.this).om(paramAnonymousInt);
        if (paramAnonymousAdapterView.type == 2)
        {
          Log.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Add member");
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(219L, 6L, 1L, true);
          SeeRoomMemberUI.f(SeeRoomMemberUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(194183);
          return;
        }
        if (paramAnonymousAdapterView.type == 3)
        {
          Log.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Delete member");
          SeeRoomMemberUI.g(SeeRoomMemberUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(194183);
          return;
        }
        if (paramAnonymousAdapterView.type == 1)
        {
          paramAnonymousAdapterView = SeeRoomMemberUI.c(SeeRoomMemberUI.this).om(paramAnonymousInt).contact;
          if (paramAnonymousAdapterView == null)
          {
            Log.e("MicroMsg.SeeRoomMemberUI", "cont is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(194183);
            return;
          }
          SeeRoomMemberUI.a(SeeRoomMemberUI.this, paramAnonymousAdapterView.field_username);
          paramAnonymousView = paramAnonymousAdapterView.field_nickname;
          localObject = SeeRoomMemberUI.a(SeeRoomMemberUI.e(SeeRoomMemberUI.this), SeeRoomMemberUI.h(SeeRoomMemberUI.this));
          if (!Util.isNullOrNil((String)localObject)) {
            break label400;
          }
          SeeRoomMemberUI.b(SeeRoomMemberUI.this, paramAnonymousAdapterView.arJ());
        }
        for (;;)
        {
          ac.u(SeeRoomMemberUI.i(SeeRoomMemberUI.this).getText().toString(), 1, 6, paramAnonymousInt + 1);
          SeeRoomMemberUI.a(SeeRoomMemberUI.this, SeeRoomMemberUI.h(SeeRoomMemberUI.this), SeeRoomMemberUI.j(SeeRoomMemberUI.this), paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(194183);
          return;
          label400:
          SeeRoomMemberUI.b(SeeRoomMemberUI.this, (String)localObject);
        }
      }
    };
    AppMethodBeat.o(194188);
  }
  
  private void DM(final String paramString)
  {
    AppMethodBeat.i(12884);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(12884);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramString);
    paramString = com.tencent.mm.roomsdk.a.b.bhF(this.gwx).a(this.gwx, localLinkedList, 0);
    paramString.b(new com.tencent.mm.roomsdk.a.b.b() {});
    paramString.c(new com.tencent.mm.roomsdk.a.b.b() {});
    paramString.a(this, getString(2131755998), getString(2131764675), true, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(194186);
        paramString.cancel();
        AppMethodBeat.o(194186);
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
    paramah = paramah.getDisplayName(paramString);
    AppMethodBeat.o(12892);
    return paramah;
  }
  
  private static int cq(Context paramContext)
  {
    AppMethodBeat.i(12879);
    int i = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
    int j = (int)(paramContext.getResources().getDimension(2131165518) * 2.0F + paramContext.getResources().getDimension(2131165526));
    i = (int)((i - paramContext.getResources().getDimension(2131165507) * 1.0F) / j);
    Log.i("MicroMsg.SeeRoomMemberUI", "[getWrapColNum] :%s", new Object[] { Integer.valueOf(i) });
    gzT = i;
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
    //   19: invokevirtual 567	java/lang/Object:getClass	()Ljava/lang/Class;
    //   22: astore 4
    //   24: aload 4
    //   26: ldc_w 452
    //   29: if_acmpeq +136 -> 165
    //   32: aload 4
    //   34: aload_1
    //   35: aload_3
    //   36: invokevirtual 573	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   39: astore 5
    //   41: aload 5
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +115 -> 160
    //   48: aload_1
    //   49: iconst_1
    //   50: invokevirtual 579	java/lang/reflect/Method:setAccessible	(Z)V
    //   53: aload_1
    //   54: aload_0
    //   55: aload_2
    //   56: invokevirtual 583	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   59: astore_0
    //   60: sipush 12893
    //   63: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_0
    //   67: areturn
    //   68: astore 5
    //   70: ldc 190
    //   72: aload 5
    //   74: ldc 103
    //   76: iconst_0
    //   77: anewarray 452	java/lang/Object
    //   80: invokestatic 587	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aload 4
    //   85: invokevirtual 590	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   88: astore 4
    //   90: goto -66 -> 24
    //   93: astore 5
    //   95: ldc 190
    //   97: aload 5
    //   99: ldc 103
    //   101: iconst_0
    //   102: anewarray 452	java/lang/Object
    //   105: invokestatic 587	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: goto -25 -> 83
    //   111: astore_0
    //   112: ldc 190
    //   114: aload_0
    //   115: ldc 103
    //   117: iconst_0
    //   118: anewarray 452	java/lang/Object
    //   121: invokestatic 587	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: aconst_null
    //   125: astore_0
    //   126: goto -66 -> 60
    //   129: astore_0
    //   130: ldc 190
    //   132: aload_0
    //   133: ldc 103
    //   135: iconst_0
    //   136: anewarray 452	java/lang/Object
    //   139: invokestatic 587	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: aconst_null
    //   143: astore_0
    //   144: goto -84 -> 60
    //   147: astore_0
    //   148: ldc 190
    //   150: aload_0
    //   151: ldc 103
    //   153: iconst_0
    //   154: anewarray 452	java/lang/Object
    //   157: invokestatic 587	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public final void ami()
  {
    AppMethodBeat.i(12881);
    ap localap = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX();
    if (this.talker == null) {}
    for (String str = this.gwx;; str = this.talker)
    {
      this.gtd = localap.Kd(str);
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194184);
          if (SeeRoomMemberUI.c(SeeRoomMemberUI.this) != null) {
            SeeRoomMemberUI.c(SeeRoomMemberUI.this).Y(this.gzX);
          }
          AppMethodBeat.o(194184);
        }
      });
      AppMethodBeat.o(12881);
      return;
    }
  }
  
  public final void amj()
  {
    AppMethodBeat.i(194189);
    if (this.gtd != null) {
      setMMTitle(this.mTitle + "(" + this.gtd.bax().size() + ")");
    }
    AppMethodBeat.o(194189);
  }
  
  public int getLayoutId()
  {
    return 2131496198;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12880);
    setMMTitle(this.mTitle + "(" + this.gxQ + ")");
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
    this.gzR = ((MMEditText)findViewById(2131305124));
    this.gzv = ((GridView)findViewById(2131298304));
    this.gzv.setNumColumns(cq(this));
    this.gzv.setColumnWidth(getResources().getDimensionPixelSize(2131165507));
    ah localah = this.gtd;
    String str = this.gwx;
    Object localObject = new LinkedList();
    if (!Util.isNullOrNil(this.gzN)) {
      localObject = Util.stringsToList(this.gzN.split(","));
    }
    ci localci = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSW().aEY("@t.qq.com");
    if (localci != null) {
      ((List)localObject).add(localci.name);
    }
    this.gzM = new b(this, localah, str, (List)localObject, this.gxR);
    this.gzR.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(12860);
        SeeRoomMemberUI.c(SeeRoomMemberUI.this).DO(paramAnonymousCharSequence.toString());
        AppMethodBeat.o(12860);
      }
    });
    this.gzv.setOnItemClickListener(this.gzU);
    this.gzv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(194182);
        if (SeeRoomMemberUI.d(SeeRoomMemberUI.this))
        {
          paramAnonymousAdapterView = SeeRoomMemberUI.c(SeeRoomMemberUI.this).om(paramAnonymousInt).contact;
          if (paramAnonymousAdapterView == null)
          {
            AppMethodBeat.o(194182);
            return true;
          }
          paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
          if (SeeRoomMemberUI.e(SeeRoomMemberUI.this).field_roomowner.equals(paramAnonymousAdapterView))
          {
            AppMethodBeat.o(194182);
            return true;
          }
          com.tencent.mm.ui.base.h.a(SeeRoomMemberUI.this, SeeRoomMemberUI.this.getString(2131764677), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(194181);
              SeeRoomMemberUI.a(SeeRoomMemberUI.this, paramAnonymousInt);
              AppMethodBeat.o(194181);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          });
        }
        for (;;)
        {
          AppMethodBeat.o(194182);
          return true;
          Log.i("MicroMsg.SeeRoomMemberUI", "U are not a roomowner");
        }
      }
    });
    this.gzv.setAdapter(this.gzM);
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
      if ((ab.Ix(this.gwx)) && (!ab.IB(this.gwx)) && (!u.HQ(str)))
      {
        com.tencent.mm.ui.base.h.c(this, getString(2131764727), getString(2131755998), true);
        AppMethodBeat.o(12886);
        return;
      }
      if (Util.nullAsNil(z.aTY()).equals(str)) {
        paramInt1 = 1;
      }
      for (;;)
      {
        label149:
        if (paramInt1 != 0)
        {
          com.tencent.mm.ui.base.h.c(this, getString(2131755172), getString(2131755998), true);
          AppMethodBeat.o(12886);
          return;
          Object localObject = v.Ic(this.gwx);
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
      if (Util.stringsToList(str.split(",")) == null)
      {
        AppMethodBeat.o(12886);
        return;
      }
      str = paramIntent.getStringExtra("Select_Contact");
      long l = paramIntent.getLongExtra("select_record_fake_msg_id", 0L);
      new com.tencent.mm.chatroom.g.a(this, this.gwx, str, localLocalHistoryInfo, l, this);
      AppMethodBeat.o(12886);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(12886);
        return;
      }
      DM(paramIntent.getStringExtra("Select_Contact"));
      break;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(12878);
    super.onConfigurationChanged(paramConfiguration);
    this.gzv.setNumColumns(cq(this));
    AppMethodBeat.o(12878);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12876);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(219L, 2L, 1L, true);
    g.aAg().hqi.a(990, this);
    this.gwx = getIntent().getStringExtra("RoomInfo_Id");
    this.talker = getIntent().getStringExtra("Chat_User");
    this.gzO = getIntent().getStringExtra("Chatroom_member_list");
    this.dRx = getIntent().getBooleanExtra("Is_Chatroom", true);
    this.gtO = getIntent().getBooleanExtra("Is_Lbsroom", false);
    this.gxS = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.gxR = getIntent().getStringExtra("room_owner_name");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    ap localap = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX();
    if (this.talker == null)
    {
      paramBundle = this.gwx;
      this.gtd = localap.Kd(paramBundle);
      this.gxQ = getIntent().getIntExtra("room_member_count", 0);
      this.gxP = getIntent().getStringExtra("room_name");
      this.fs = getIntent().getIntExtra("offset", 0);
      this.gzS = getIntent().getIntExtra("first_pos", 0);
      initView();
      if (this.gzM != null)
      {
        ami();
        paramBundle = this.gzv;
        if (this.gzS * gzT >= this.gzM.getCount()) {
          break label336;
        }
      }
    }
    label336:
    for (int i = this.gzS * gzT;; i = this.gzM.getCount() - 1)
    {
      paramBundle.setSelection(i);
      this.gzv.postDelayed(new Runnable()
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
    g.aAg().hqi.b(990, this);
    if ((this.gxX != null) && (this.gxX.isShowing())) {
      this.gxX.dismiss();
    }
    super.onDestroy();
    AppMethodBeat.o(12883);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(12882);
    super.onPause();
    if (this.gzP != null) {
      this.gzP.gXP();
    }
    AppMethodBeat.o(12882);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12877);
    super.onResume();
    if (this.gzM != null) {
      this.gzM.DO(this.gzR.getText().toString());
    }
    AppMethodBeat.o(12877);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(12885);
    if ((this.gxX != null) && (this.gxX.isShowing())) {
      this.gxX.dismiss();
    }
    paramString = com.tencent.mm.h.a.Dk(paramString);
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
    private List<SeeRoomMemberUI.a> dSU;
    private boolean gAa;
    private String gAb;
    private List<SeeRoomMemberUI.a> gAc;
    private com.tencent.mm.plugin.messenger.foundation.a.l gAd;
    private ah gtd;
    private List<String> gzY;
    public String gzZ;
    private Context mContext;
    private String roomId;
    
    public b(ah paramah, String paramString1, List<String> paramList, String paramString2)
    {
      AppMethodBeat.i(12868);
      this.gAa = false;
      this.gAb = null;
      this.dSU = new ArrayList();
      this.gtd = paramString1;
      this.roomId = paramList;
      this.gzY = paramString2;
      Object localObject;
      this.gAb = localObject;
      this.mContext = paramah;
      this.gAd = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class));
      Y(v.Ic(paramList));
      AppMethodBeat.o(12868);
    }
    
    private void DN(String paramString)
    {
      AppMethodBeat.i(12870);
      ArrayList localArrayList = new ArrayList();
      if (!Util.isNullOrNil(paramString))
      {
        Iterator localIterator = this.gAc.iterator();
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
            else if ((!Util.isNullOrNil(SeeRoomMemberUI.a(this.gtd, ((ax)localObject).field_username))) && (SeeRoomMemberUI.a(this.gtd, ((ax)localObject).field_username).contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((as)localObject).arI() != null) && (((as)localObject).arI().toUpperCase().contains(paramString.toUpperCase())))
            {
              localArrayList.add(locala);
            }
            else if ((((as)localObject).ajz() != null) && (((as)localObject).ajz().toUpperCase().contains(paramString.toUpperCase())))
            {
              localArrayList.add(locala);
            }
            else if ((((as)localObject).ajx() != null) && (((as)localObject).ajx().contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((ax)localObject).field_username != null) && (((ax)localObject).field_username.contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if (!com.tencent.mm.contact.c.oR(((ax)localObject).field_type))
            {
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSO().aEZ(((ax)localObject).field_username);
              if ((localObject != null) && (((cn)localObject).field_conRemark != null) && (((cn)localObject).field_conRemark.toUpperCase().contains(paramString.toUpperCase()))) {
                localArrayList.add(locala);
              }
            }
          }
        }
        Log.i("MicroMsg.SeeRoomMemberUI", "[setMemberListBySearch]");
      }
      for (this.dSU = localArrayList;; this.dSU = this.gAc)
      {
        notifyDataSetChanged();
        AppMethodBeat.o(12870);
        return;
      }
    }
    
    public final void DO(String paramString)
    {
      AppMethodBeat.i(12873);
      this.gAa = true;
      this.gzZ = paramString;
      DN(paramString);
      AppMethodBeat.o(12873);
    }
    
    public final void Y(List<String> paramList)
    {
      AppMethodBeat.i(12869);
      if (paramList == null)
      {
        AppMethodBeat.o(12869);
        return;
      }
      this.dSU.clear();
      int i = 0;
      if (i < paramList.size())
      {
        as localas = this.gAd.aSN().Kn((String)paramList.get(i));
        if (this.gtd.JO(localas.field_username)) {
          this.dSU.add(new SeeRoomMemberUI.a(localas, 3));
        }
        for (;;)
        {
          i += 1;
          break;
          if (this.gtd.bjf(localas.field_username)) {
            this.dSU.add(new SeeRoomMemberUI.a(localas, 2));
          } else {
            this.dSU.add(new SeeRoomMemberUI.a(localas, 1));
          }
        }
      }
      Collections.sort(this.dSU, new Comparator() {});
      this.dSU.add(new SeeRoomMemberUI.a(2));
      if (this.gtd.amD()) {
        this.dSU.add(new SeeRoomMemberUI.a(3));
      }
      this.gAc = this.dSU;
      notifyDataSetChanged();
      AppMethodBeat.o(12869);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(12874);
      int i = this.dSU.size();
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
        localView = View.inflate(this.mContext, 2131496197, null);
        localc = new SeeRoomMemberUI.c((byte)0);
        localc.gAf = ((AvatarPatTipImageView)localView.findViewById(2131307477));
        localc.gwR = ((TextView)localView.findViewById(2131307479));
        paramView = (WindowManager)this.mContext.getSystemService("window");
        localc.gwR.setMaxWidth(paramView.getDefaultDisplay().getWidth() * 2 / 3);
        localc.gAg = ((TextView)localView.findViewById(2131307480));
        localView.setTag(localc);
        localc.gAf.setTag(Integer.valueOf(paramInt));
        if (localc.gAg != null) {
          localc.gAg.setVisibility(8);
        }
        paramView = (SeeRoomMemberUI.a)this.dSU.get(paramInt);
        if ((paramView == null) || (paramView.type != 1)) {
          break label472;
        }
        as localas = paramView.contact;
        com.tencent.mm.pluginsdk.ui.a.b.c(localc.gAf, localas.field_username);
        str = SeeRoomMemberUI.a(this.gtd, localas.field_username);
        if (Util.isNullOrNil(localas.field_conRemark)) {
          break label445;
        }
        paramViewGroup = localas.field_conRemark;
        label229:
        paramView = paramViewGroup;
        if (Util.isNullOrNil(paramViewGroup)) {
          paramView = localas.arI();
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
        localc.gwR.setVisibility(0);
        localc.gwR.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, paramViewGroup, localc.gwR.getTextSize()));
        localc.gAf.setTagUsername(localas.field_username);
        localc.gAf.setTagTalker(this.roomId);
        localc.gAf.setTagScene(4);
        localc.gAf.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(194187);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SeeRoomMemberUI$ChatroomMemberAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            Log.i("MicroMsg.SeeRoomMemberUI", "onItemClick %s%s", new Object[] { paramAnonymousView, paramAnonymousView.getTag() });
            if (paramAnonymousView.getTag() != null)
            {
              int i = ((Integer)paramAnonymousView.getTag()).intValue();
              SeeRoomMemberUI.k(SeeRoomMemberUI.this).onItemClick(SeeRoomMemberUI.b(SeeRoomMemberUI.this), paramAnonymousView, i, SeeRoomMemberUI.b.this.getItemId(i));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$ChatroomMemberAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(194187);
          }
        });
        if (localc.gAg != null)
        {
          paramView = com.tencent.mm.openim.room.a.a.O(localas);
          if (!TextUtils.isEmpty(paramView)) {
            break label451;
          }
          localc.gAg.setVisibility(8);
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
        localc.gAg.setVisibility(0);
        localc.gAg.setText(paramView);
        continue;
        label472:
        if ((paramView != null) && (paramView.type == 2))
        {
          localc.gwR.setVisibility(4);
          localc.gAf.setImageResource(2131231212);
          localc.gAf.setTagUsername("");
        }
        else if ((paramView != null) && (paramView.type == 3))
        {
          localc.gwR.setVisibility(4);
          localc.gAf.setImageResource(2131231213);
          localc.gAf.setTagUsername("");
        }
      }
    }
    
    public final SeeRoomMemberUI.a om(int paramInt)
    {
      AppMethodBeat.i(12871);
      SeeRoomMemberUI.a locala = (SeeRoomMemberUI.a)this.dSU.get(paramInt);
      AppMethodBeat.o(12871);
      return locala;
    }
  }
  
  static final class c
  {
    public AvatarPatTipImageView gAf;
    public TextView gAg;
    public TextView gwR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomMemberUI
 * JD-Core Version:    0.7.0.1
 */