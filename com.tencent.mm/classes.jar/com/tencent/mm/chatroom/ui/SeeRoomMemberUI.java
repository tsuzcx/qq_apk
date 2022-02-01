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
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.c.av;
import com.tencent.mm.m.e;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SeeRoomMemberUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private static int fzt = 5;
  private int MW;
  private boolean dmR;
  private x ftP;
  private boolean ftu;
  private String fvZ;
  private String fxo;
  private int fxp;
  private String fxq;
  private boolean fxr;
  private com.tencent.mm.ui.base.p fxw;
  private GridView fyV;
  private b fzm;
  private String fzn;
  private String fzo;
  private r fzp;
  private String fzq;
  private MMEditText fzr;
  private int fzs;
  private String mTitle;
  private String talker;
  private String username;
  
  private static List<String> Q(List<String> paramList)
  {
    AppMethodBeat.i(12890);
    LinkedList localLinkedList = new LinkedList();
    if (!com.tencent.mm.kernel.g.agM())
    {
      AppMethodBeat.o(12890);
      return localLinkedList;
    }
    if (paramList == null)
    {
      AppMethodBeat.o(12890);
      return localLinkedList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(str);
      paramList = str;
      if (localai != null)
      {
        paramList = str;
        if ((int)localai.fLJ != 0) {
          paramList = localai.aaS();
        }
      }
      localLinkedList.add(paramList);
    }
    AppMethodBeat.o(12890);
    return localLinkedList;
  }
  
  private void WO()
  {
    AppMethodBeat.i(12881);
    aj localaj = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK();
    if (this.talker == null) {}
    for (Object localObject = this.fvZ;; localObject = this.talker)
    {
      this.ftP = localaj.xN((String)localObject);
      localObject = com.tencent.mm.model.q.vZ(this.fvZ);
      if (this.fzm != null) {
        this.fzm.R((List)localObject);
      }
      AppMethodBeat.o(12881);
      return;
    }
  }
  
  private static boolean Wh()
  {
    AppMethodBeat.i(12889);
    if (bs.getInt(com.tencent.mm.m.g.ZY().getValue("ChatroomGlobalSwitch"), 1) == 1)
    {
      AppMethodBeat.o(12889);
      return true;
    }
    AppMethodBeat.o(12889);
    return false;
  }
  
  protected static String a(x paramx, String paramString)
  {
    AppMethodBeat.i(12892);
    if (paramx == null)
    {
      AppMethodBeat.o(12892);
      return "";
    }
    paramx = paramx.wk(paramString);
    AppMethodBeat.o(12892);
    return paramx;
  }
  
  private static int bV(Context paramContext)
  {
    AppMethodBeat.i(12879);
    int i = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
    int j = (int)(paramContext.getResources().getDimension(2131165500) * 2.0F + paramContext.getResources().getDimension(2131165508));
    i = (int)((i - paramContext.getResources().getDimension(2131165489) * 1.0F) / j);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SeeRoomMemberUI", "[getWrapColNum] :%s", new Object[] { Integer.valueOf(i) });
    fzt = i;
    AppMethodBeat.o(12879);
    return i;
  }
  
  private void c(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(12888);
    if ((paramList != null) && (paramList.size() > 0))
    {
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      while (i < paramList.size())
      {
        localLinkedList.add(paramList.get(i));
        i += 1;
      }
      paramList = "weixin://findfriend/verifycontact/" + paramString + "/";
      com.tencent.mm.model.p.a(paramString, localLinkedList, getString(2131757105), true, paramList);
    }
    AppMethodBeat.o(12888);
  }
  
  private void h(final String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(12887);
    if ((w.wp(this.fvZ)) && (!w.ws(this.fvZ)) && (!com.tencent.mm.model.p.vN(paramString1)))
    {
      com.tencent.mm.ui.base.h.c(this, getString(2131762644), getString(2131755906), true);
      AppMethodBeat.o(12887);
      return;
    }
    if (sf(paramString1))
    {
      com.tencent.mm.ui.base.h.c(this, getString(2131755154), getString(2131755906), true);
      AppMethodBeat.o(12887);
      return;
    }
    paramString1 = bs.S(paramString1.split(","));
    if (paramString1 == null)
    {
      AppMethodBeat.o(12887);
      return;
    }
    paramString1 = com.tencent.mm.roomsdk.a.b.aJZ(this.fvZ).a(this.fvZ, paramString1, paramString2);
    paramString1.d(new com.tencent.mm.roomsdk.a.b.c() {});
    getString(2131755906);
    paramString1.a(this, getString(paramInt), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(12852);
        paramString1.cancel();
        AppMethodBeat.o(12852);
      }
    });
    AppMethodBeat.o(12887);
  }
  
  /* Error */
  private static Object invokeMethod(Object paramObject, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    // Byte code:
    //   0: sipush 12893
    //   3: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnonnull +11 -> 18
    //   10: sipush 12893
    //   13: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: invokevirtual 810	java/lang/Object:getClass	()Ljava/lang/Class;
    //   22: astore 4
    //   24: aload 4
    //   26: ldc_w 387
    //   29: if_acmpeq +141 -> 170
    //   32: aload 4
    //   34: aload_1
    //   35: aload_3
    //   36: invokevirtual 816	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   39: astore 5
    //   41: aload 5
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +120 -> 165
    //   48: aload_1
    //   49: iconst_1
    //   50: invokevirtual 822	java/lang/reflect/Method:setAccessible	(Z)V
    //   53: aload_1
    //   54: aload_0
    //   55: aload_2
    //   56: invokevirtual 826	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   59: astore_0
    //   60: sipush 12893
    //   63: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_0
    //   67: areturn
    //   68: astore 5
    //   70: ldc_w 256
    //   73: aload 5
    //   75: ldc 232
    //   77: iconst_0
    //   78: anewarray 387	java/lang/Object
    //   81: invokestatic 830	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: aload 4
    //   86: invokevirtual 833	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   89: astore 4
    //   91: goto -67 -> 24
    //   94: astore 5
    //   96: ldc_w 256
    //   99: aload 5
    //   101: ldc 232
    //   103: iconst_0
    //   104: anewarray 387	java/lang/Object
    //   107: invokestatic 830	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   110: goto -26 -> 84
    //   113: astore_0
    //   114: ldc_w 256
    //   117: aload_0
    //   118: ldc 232
    //   120: iconst_0
    //   121: anewarray 387	java/lang/Object
    //   124: invokestatic 830	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: aconst_null
    //   128: astore_0
    //   129: goto -69 -> 60
    //   132: astore_0
    //   133: ldc_w 256
    //   136: aload_0
    //   137: ldc 232
    //   139: iconst_0
    //   140: anewarray 387	java/lang/Object
    //   143: invokestatic 830	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: aconst_null
    //   147: astore_0
    //   148: goto -88 -> 60
    //   151: astore_0
    //   152: ldc_w 256
    //   155: aload_0
    //   156: ldc 232
    //   158: iconst_0
    //   159: anewarray 387	java/lang/Object
    //   162: invokestatic 830	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   165: aconst_null
    //   166: astore_0
    //   167: goto -107 -> 60
    //   170: aconst_null
    //   171: astore_1
    //   172: goto -128 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	paramObject	Object
    //   0	175	1	paramString	String
    //   0	175	2	paramArrayOfObject	Object[]
    //   0	175	3	paramArrayOfClass	Class[]
    //   22	68	4	localClass	Class
    //   39	3	5	localMethod	java.lang.reflect.Method
    //   68	6	5	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   94	6	5	localSecurityException	java.lang.SecurityException
    // Exception table:
    //   from	to	target	type
    //   32	41	68	java/lang/NoSuchMethodException
    //   32	41	94	java/lang/SecurityException
    //   53	60	113	java/lang/IllegalAccessException
    //   53	60	132	java/lang/IllegalArgumentException
    //   53	60	151	java/lang/reflect/InvocationTargetException
  }
  
  private boolean sf(String paramString)
  {
    AppMethodBeat.i(12891);
    if (bs.nullAsNil(u.axw()).equals(paramString))
    {
      AppMethodBeat.o(12891);
      return true;
    }
    Object localObject = com.tencent.mm.model.q.vZ(this.fvZ);
    if (localObject == null)
    {
      AppMethodBeat.o(12891);
      return false;
    }
    localObject = ((List)localObject).iterator();
    boolean bool = false;
    if (((Iterator)localObject).hasNext())
    {
      if (!((String)((Iterator)localObject).next()).equals(paramString)) {
        break label94;
      }
      bool = true;
    }
    label94:
    for (;;)
    {
      break;
      AppMethodBeat.o(12891);
      return bool;
    }
  }
  
  private void sk(final String paramString)
  {
    AppMethodBeat.i(12884);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(12884);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramString);
    paramString = com.tencent.mm.roomsdk.a.b.aJZ(this.fvZ).a(this.fvZ, localLinkedList, 0);
    paramString.b(new com.tencent.mm.roomsdk.a.b.b() {});
    paramString.c(new com.tencent.mm.roomsdk.a.b.b() {});
    getString(2131755906);
    paramString.a(this, getString(2131762595), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(12866);
        paramString.cancel();
        AppMethodBeat.o(12866);
      }
    });
    AppMethodBeat.o(12884);
  }
  
  public int getLayoutId()
  {
    return 2131495337;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12880);
    setMMTitle(this.mTitle + "(" + this.fxp + ")");
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
    this.fzr = ((MMEditText)findViewById(2131302626));
    this.fyV = ((GridView)findViewById(2131297966));
    this.fyV.setNumColumns(bV(this));
    this.fyV.setColumnWidth(getResources().getDimensionPixelSize(2131165489));
    x localx = this.ftP;
    String str = this.fvZ;
    Object localObject = new LinkedList();
    if (!bs.isNullOrNil(this.fzn)) {
      localObject = bs.S(this.fzn.split(","));
    }
    bu localbu = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awJ().alJ("@t.qq.com");
    if (localbu != null) {
      ((List)localObject).add(localbu.name);
    }
    this.fzm = new b(this, localx, str, (List)localObject, this.fxq);
    this.fzr.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(12860);
        SeeRoomMemberUI.c(SeeRoomMemberUI.this).sm(paramAnonymousCharSequence.toString());
        AppMethodBeat.o(12860);
      }
    });
    this.fyV.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(12861);
        paramAnonymousAdapterView = SeeRoomMemberUI.c(SeeRoomMemberUI.this).kJ(paramAnonymousInt);
        if (paramAnonymousAdapterView.type == 2)
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Add member");
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(219L, 6L, 1L, true);
          SeeRoomMemberUI.d(SeeRoomMemberUI.this);
          AppMethodBeat.o(12861);
          return;
        }
        if (paramAnonymousAdapterView.type == 3)
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Delete member");
          SeeRoomMemberUI.e(SeeRoomMemberUI.this);
          AppMethodBeat.o(12861);
          return;
        }
        String str;
        if (paramAnonymousAdapterView.type == 1)
        {
          paramAnonymousAdapterView = SeeRoomMemberUI.c(SeeRoomMemberUI.this).kJ(paramAnonymousInt).contact;
          if (paramAnonymousAdapterView == null)
          {
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.SeeRoomMemberUI", "cont is null");
            AppMethodBeat.o(12861);
            return;
          }
          SeeRoomMemberUI.a(SeeRoomMemberUI.this, paramAnonymousAdapterView.field_username);
          paramAnonymousView = paramAnonymousAdapterView.field_nickname;
          str = SeeRoomMemberUI.a(SeeRoomMemberUI.f(SeeRoomMemberUI.this), SeeRoomMemberUI.g(SeeRoomMemberUI.this));
          if (!bs.isNullOrNil(str)) {
            break label238;
          }
          SeeRoomMemberUI.b(SeeRoomMemberUI.this, paramAnonymousAdapterView.aaS());
        }
        for (;;)
        {
          com.tencent.mm.ui.contact.ac.u(SeeRoomMemberUI.h(SeeRoomMemberUI.this).getText().toString(), 1, 6, paramAnonymousInt + 1);
          SeeRoomMemberUI.a(SeeRoomMemberUI.this, SeeRoomMemberUI.g(SeeRoomMemberUI.this), SeeRoomMemberUI.i(SeeRoomMemberUI.this), paramAnonymousView);
          AppMethodBeat.o(12861);
          return;
          label238:
          SeeRoomMemberUI.b(SeeRoomMemberUI.this, str);
        }
      }
    });
    this.fyV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(12863);
        if (SeeRoomMemberUI.j(SeeRoomMemberUI.this))
        {
          paramAnonymousAdapterView = SeeRoomMemberUI.c(SeeRoomMemberUI.this).kJ(paramAnonymousInt).contact;
          if (paramAnonymousAdapterView == null)
          {
            AppMethodBeat.o(12863);
            return true;
          }
          paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
          if (SeeRoomMemberUI.f(SeeRoomMemberUI.this).field_roomowner.equals(paramAnonymousAdapterView))
          {
            AppMethodBeat.o(12863);
            return true;
          }
          com.tencent.mm.ui.base.h.a(SeeRoomMemberUI.this, SeeRoomMemberUI.this.getString(2131762597), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(12862);
              SeeRoomMemberUI.a(SeeRoomMemberUI.this, paramAnonymousInt);
              AppMethodBeat.o(12862);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          });
        }
        for (;;)
        {
          AppMethodBeat.o(12863);
          return true;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SeeRoomMemberUI", "U are not a roomowner");
        }
      }
    });
    this.fyV.setAdapter(this.fzm);
    AppMethodBeat.o(12880);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(12886);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(12886);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(12886);
        return;
      }
      String str = paramIntent.getStringExtra("Select_Contact");
      if ((w.wp(this.fvZ)) && (!w.ws(this.fvZ)) && (!com.tencent.mm.model.p.vN(str)))
      {
        com.tencent.mm.ui.base.h.c(this, getString(2131762644), getString(2131755906), true);
        AppMethodBeat.o(12886);
        return;
      }
      if (sf(str))
      {
        com.tencent.mm.ui.base.h.c(this, getString(2131755154), getString(2131755906), true);
        AppMethodBeat.o(12886);
        return;
      }
      if (bs.S(str.split(",")) == null)
      {
        AppMethodBeat.o(12886);
        return;
      }
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      x localx = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(this.fvZ);
      if (localx != null)
      {
        if (localx.eZN() == 2)
        {
          new f.a(this).aRQ(getString(2131762554)).aRU(getString(2131755884)).yi(true).p(Boolean.TRUE).aRV(getString(2131755691)).aRS(getString(2131762208)).c(new f.c()
          {
            public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
            {
              AppMethodBeat.i(12867);
              if (paramAnonymousBoolean) {
                SeeRoomMemberUI.a(SeeRoomMemberUI.this, paramIntent, paramAnonymousString);
              }
              AppMethodBeat.o(12867);
            }
          }).show();
          AppMethodBeat.o(12886);
          return;
        }
        h(str, null, 2131755168);
        AppMethodBeat.o(12886);
        return;
        if (paramIntent == null)
        {
          AppMethodBeat.o(12886);
          return;
        }
        sk(paramIntent.getStringExtra("Select_Contact"));
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(12878);
    super.onConfigurationChanged(paramConfiguration);
    this.fyV.setNumColumns(bV(this));
    AppMethodBeat.o(12878);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12876);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(219L, 2L, 1L, true);
    com.tencent.mm.kernel.g.agQ().ghe.a(990, this);
    this.fvZ = getIntent().getStringExtra("RoomInfo_Id");
    this.talker = getIntent().getStringExtra("Chat_User");
    this.fzo = getIntent().getStringExtra("Chatroom_member_list");
    this.dmR = getIntent().getBooleanExtra("Is_Chatroom", true);
    this.ftu = getIntent().getBooleanExtra("Is_Lbsroom", false);
    this.fxr = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.fxq = getIntent().getStringExtra("room_owner_name");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    aj localaj = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK();
    if (this.talker == null)
    {
      paramBundle = this.fvZ;
      this.ftP = localaj.xN(paramBundle);
      this.fxp = getIntent().getIntExtra("room_member_count", 0);
      this.fxo = getIntent().getStringExtra("room_name");
      this.MW = getIntent().getIntExtra("offset", 0);
      this.fzs = getIntent().getIntExtra("first_pos", 0);
      initView();
      if (this.fzm != null)
      {
        WO();
        paramBundle = this.fyV;
        if (this.fzs * fzt >= this.fzm.getCount()) {
          break label335;
        }
      }
    }
    label335:
    for (int i = this.fzs * fzt;; i = this.fzm.getCount() - 1)
    {
      paramBundle.setSelection(i);
      this.fyV.postDelayed(new Runnable()
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
    com.tencent.mm.kernel.g.agQ().ghe.b(990, this);
    if ((this.fxw != null) && (this.fxw.isShowing())) {
      this.fxw.dismiss();
    }
    super.onDestroy();
    AppMethodBeat.o(12883);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(12882);
    super.onPause();
    if (this.fzp != null) {
      this.fzp.ftR();
    }
    AppMethodBeat.o(12882);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12877);
    super.onResume();
    if (this.fzm != null) {
      this.fzm.sm(this.fzr.getText().toString());
    }
    AppMethodBeat.o(12877);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(12885);
    if ((this.fxw != null) && (this.fxw.isShowing())) {
      this.fxw.dismiss();
    }
    paramString = com.tencent.mm.h.a.rM(paramString);
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
    ai contact;
    int order = 0;
    int type;
    
    public a(int paramInt)
    {
      this.type = paramInt;
      this.contact = null;
    }
    
    public a(ai paramai, int paramInt)
    {
      this.type = 1;
      this.contact = paramai;
      this.order = paramInt;
    }
  }
  
  final class b
    extends BaseAdapter
  {
    private List<SeeRoomMemberUI.a> dom;
    private x ftP;
    private List<SeeRoomMemberUI.a> fzA;
    private com.tencent.mm.plugin.messenger.foundation.a.k fzB;
    private List<String> fzw;
    public String fzx;
    private boolean fzy;
    private String fzz;
    private Context mContext;
    private String roomId;
    
    public b(x paramx, String paramString1, List<String> paramList, String paramString2)
    {
      AppMethodBeat.i(12868);
      this.fzy = false;
      this.fzz = null;
      this.dom = new ArrayList();
      this.ftP = paramString1;
      this.roomId = paramList;
      this.fzw = paramString2;
      Object localObject;
      this.fzz = localObject;
      this.mContext = paramx;
      this.fzB = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class));
      R(com.tencent.mm.model.q.vZ(paramList));
      AppMethodBeat.o(12868);
    }
    
    private void sl(String paramString)
    {
      AppMethodBeat.i(12870);
      ArrayList localArrayList = new ArrayList();
      if (!bs.isNullOrNil(paramString))
      {
        Iterator localIterator = this.fzA.iterator();
        while (localIterator.hasNext())
        {
          SeeRoomMemberUI.a locala = (SeeRoomMemberUI.a)localIterator.next();
          if ((locala != null) && (locala.contact != null) && (locala.type == 1))
          {
            Object localObject = locala.contact;
            if ((((av)localObject).field_conRemark != null) && (((av)localObject).field_conRemark.toUpperCase().contains(paramString.toUpperCase())))
            {
              localArrayList.add(locala);
            }
            else if ((!bs.isNullOrNil(SeeRoomMemberUI.a(this.ftP, ((av)localObject).field_username))) && (SeeRoomMemberUI.a(this.ftP, ((av)localObject).field_username).contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((ai)localObject).aaR() != null) && (((ai)localObject).aaR().toUpperCase().contains(paramString.toUpperCase())))
            {
              localArrayList.add(locala);
            }
            else if ((((ai)localObject).To() != null) && (((ai)localObject).To().toUpperCase().contains(paramString.toUpperCase())))
            {
              localArrayList.add(locala);
            }
            else if ((((ai)localObject).Tl() != null) && (((ai)localObject).Tl().contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((av)localObject).field_username != null) && (((av)localObject).field_username.contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if (!com.tencent.mm.n.b.ln(((av)localObject).field_type))
            {
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awC().alK(((av)localObject).field_username);
              if ((localObject != null) && (((bz)localObject).field_conRemark != null) && (((bz)localObject).field_conRemark.toUpperCase().contains(paramString.toUpperCase()))) {
                localArrayList.add(locala);
              }
            }
          }
        }
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.SeeRoomMemberUI", "[setMemberListBySearch]");
      }
      for (this.dom = localArrayList;; this.dom = this.fzA)
      {
        notifyDataSetChanged();
        AppMethodBeat.o(12870);
        return;
      }
    }
    
    public final void R(List<String> paramList)
    {
      AppMethodBeat.i(12869);
      if (paramList == null)
      {
        AppMethodBeat.o(12869);
        return;
      }
      this.dom.clear();
      int i = 0;
      if (i < paramList.size())
      {
        ai localai = this.fzB.awB().aNt((String)paramList.get(i));
        if (this.ftP.xB(localai.field_username)) {
          this.dom.add(new SeeRoomMemberUI.a(localai, 3));
        }
        for (;;)
        {
          i += 1;
          break;
          if (this.ftP.aMU(localai.field_username)) {
            this.dom.add(new SeeRoomMemberUI.a(localai, 2));
          } else {
            this.dom.add(new SeeRoomMemberUI.a(localai, 1));
          }
        }
      }
      Collections.sort(this.dom, new Comparator() {});
      this.dom.add(new SeeRoomMemberUI.a(2));
      if (this.ftP.Wp()) {
        this.dom.add(new SeeRoomMemberUI.a(3));
      }
      this.fzA = this.dom;
      notifyDataSetChanged();
      AppMethodBeat.o(12869);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(12874);
      int i = this.dom.size();
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
        localc.fuY = ((ImageView)localView.findViewById(2131304481));
        localc.fwp = ((TextView)localView.findViewById(2131304483));
        paramView = (WindowManager)this.mContext.getSystemService("window");
        localc.fwp.setMaxWidth(paramView.getDefaultDisplay().getWidth() * 2 / 3);
        localc.fzD = ((TextView)localView.findViewById(2131304484));
        localView.setTag(localc);
        localc.fuY.setTag(Integer.valueOf(paramInt));
        if (localc.fzD != null) {
          localc.fzD.setVisibility(8);
        }
        paramView = (SeeRoomMemberUI.a)this.dom.get(paramInt);
        if ((paramView == null) || (paramView.type != 1)) {
          break label421;
        }
        ai localai = paramView.contact;
        a.b.c(localc.fuY, localai.field_username);
        str = SeeRoomMemberUI.a(this.ftP, localai.field_username);
        if (bs.isNullOrNil(localai.field_conRemark)) {
          break label394;
        }
        paramViewGroup = localai.field_conRemark;
        label228:
        paramView = paramViewGroup;
        if (bs.isNullOrNil(paramViewGroup)) {
          paramView = localai.aaR();
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
        localc.fwp.setVisibility(0);
        localc.fwp.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, paramViewGroup, localc.fwp.getTextSize()));
        if (localc.fzD != null)
        {
          paramView = com.tencent.mm.openim.room.a.a.H(localai);
          if (!TextUtils.isEmpty(paramView)) {
            break label400;
          }
          localc.fzD.setVisibility(8);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(12872);
        return localView;
        localc = (SeeRoomMemberUI.c)paramView.getTag();
        localView = paramView;
        break;
        label394:
        paramViewGroup = str;
        break label228;
        label400:
        localc.fzD.setVisibility(0);
        localc.fzD.setText(paramView);
        continue;
        label421:
        if ((paramView != null) && (paramView.type == 2))
        {
          localc.fwp.setVisibility(4);
          localc.fuY.setImageResource(2131231164);
        }
        else if ((paramView != null) && (paramView.type == 3))
        {
          localc.fwp.setVisibility(4);
          localc.fuY.setImageResource(2131231165);
        }
      }
    }
    
    public final SeeRoomMemberUI.a kJ(int paramInt)
    {
      AppMethodBeat.i(12871);
      SeeRoomMemberUI.a locala = (SeeRoomMemberUI.a)this.dom.get(paramInt);
      AppMethodBeat.o(12871);
      return locala;
    }
    
    public final void sm(String paramString)
    {
      AppMethodBeat.i(12873);
      this.fzy = true;
      this.fzx = paramString;
      sl(paramString);
      AppMethodBeat.o(12873);
    }
  }
  
  static final class c
  {
    public ImageView fuY;
    public TextView fwp;
    public TextView fzD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomMemberUI
 * JD-Core Version:    0.7.0.1
 */