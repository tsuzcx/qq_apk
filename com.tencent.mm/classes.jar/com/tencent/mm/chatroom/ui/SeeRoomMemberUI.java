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
import com.tencent.mm.al.n;
import com.tencent.mm.g.c.au;
import com.tencent.mm.m.e;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.contact.ac;
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
  implements com.tencent.mm.al.g
{
  private static int fvM = 5;
  private int LZ;
  private boolean dph;
  private boolean fpQ;
  private com.tencent.mm.storage.w fql;
  private String fss;
  private String ftH;
  private int ftI;
  private String ftJ;
  private boolean ftK;
  private com.tencent.mm.ui.base.p ftP;
  private b fvF;
  private String fvG;
  private String fvH;
  private r fvI;
  private String fvJ;
  private MMEditText fvK;
  private int fvL;
  private GridView fvo;
  private String mTitle;
  private String talker;
  private String username;
  
  private void VQ()
  {
    AppMethodBeat.i(12881);
    aj localaj = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV();
    if (this.talker == null) {}
    for (Object localObject = this.fss;; localObject = this.talker)
    {
      this.fql = localaj.tH((String)localObject);
      localObject = com.tencent.mm.model.q.rW(this.fss);
      if (this.fvF != null) {
        this.fvF.aa((List)localObject);
      }
      AppMethodBeat.o(12881);
      return;
    }
  }
  
  private static boolean Vi()
  {
    AppMethodBeat.i(12889);
    if (bt.getInt(com.tencent.mm.m.g.Zd().getValue("ChatroomGlobalSwitch"), 1) == 1)
    {
      AppMethodBeat.o(12889);
      return true;
    }
    AppMethodBeat.o(12889);
    return false;
  }
  
  private static List<String> Z(List<String> paramList)
  {
    AppMethodBeat.i(12890);
    LinkedList localLinkedList = new LinkedList();
    if (!com.tencent.mm.kernel.g.afw())
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
      af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(str);
      paramList = str;
      if (localaf != null)
      {
        paramList = str;
        if ((int)localaf.fId != 0) {
          paramList = localaf.ZX();
        }
      }
      localLinkedList.add(paramList);
    }
    AppMethodBeat.o(12890);
    return localLinkedList;
  }
  
  protected static String a(com.tencent.mm.storage.w paramw, String paramString)
  {
    AppMethodBeat.i(12892);
    if (paramw == null)
    {
      AppMethodBeat.o(12892);
      return "";
    }
    paramw = paramw.sh(paramString);
    AppMethodBeat.o(12892);
    return paramw;
  }
  
  private static int bS(Context paramContext)
  {
    AppMethodBeat.i(12879);
    int i = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
    int j = (int)(paramContext.getResources().getDimension(2131165500) * 2.0F + paramContext.getResources().getDimension(2131165508));
    i = (int)((i - paramContext.getResources().getDimension(2131165489) * 1.0F) / j);
    ad.i("MicroMsg.SeeRoomMemberUI", "[getWrapColNum] :%s", new Object[] { Integer.valueOf(i) });
    fvM = i;
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
  
  private void g(final String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(12887);
    if ((com.tencent.mm.model.w.sm(this.fss)) && (!com.tencent.mm.model.w.sp(this.fss)) && (!com.tencent.mm.model.p.rK(paramString1)))
    {
      com.tencent.mm.ui.base.h.c(this, getString(2131762644), getString(2131755906), true);
      AppMethodBeat.o(12887);
      return;
    }
    if (oT(paramString1))
    {
      com.tencent.mm.ui.base.h.c(this, getString(2131755154), getString(2131755906), true);
      AppMethodBeat.o(12887);
      return;
    }
    paramString1 = bt.S(paramString1.split(","));
    if (paramString1 == null)
    {
      AppMethodBeat.o(12887);
      return;
    }
    paramString1 = com.tencent.mm.roomsdk.a.b.aEI(this.fss).a(this.fss, paramString1, paramString2);
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
    //   3: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnonnull +11 -> 18
    //   10: sipush 12893
    //   13: invokestatic 142	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: invokevirtual 810	java/lang/Object:getClass	()Ljava/lang/Class;
    //   22: astore 4
    //   24: aload 4
    //   26: ldc_w 386
    //   29: if_acmpeq +136 -> 165
    //   32: aload 4
    //   34: aload_1
    //   35: aload_3
    //   36: invokevirtual 816	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   39: astore 5
    //   41: aload 5
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +115 -> 160
    //   48: aload_1
    //   49: iconst_1
    //   50: invokevirtual 822	java/lang/reflect/Method:setAccessible	(Z)V
    //   53: aload_1
    //   54: aload_0
    //   55: aload_2
    //   56: invokevirtual 826	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   59: astore_0
    //   60: sipush 12893
    //   63: invokestatic 142	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_0
    //   67: areturn
    //   68: astore 5
    //   70: ldc 255
    //   72: aload 5
    //   74: ldc 231
    //   76: iconst_0
    //   77: anewarray 386	java/lang/Object
    //   80: invokestatic 830	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aload 4
    //   85: invokevirtual 833	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   88: astore 4
    //   90: goto -66 -> 24
    //   93: astore 5
    //   95: ldc 255
    //   97: aload 5
    //   99: ldc 231
    //   101: iconst_0
    //   102: anewarray 386	java/lang/Object
    //   105: invokestatic 830	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: goto -25 -> 83
    //   111: astore_0
    //   112: ldc 255
    //   114: aload_0
    //   115: ldc 231
    //   117: iconst_0
    //   118: anewarray 386	java/lang/Object
    //   121: invokestatic 830	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: aconst_null
    //   125: astore_0
    //   126: goto -66 -> 60
    //   129: astore_0
    //   130: ldc 255
    //   132: aload_0
    //   133: ldc 231
    //   135: iconst_0
    //   136: anewarray 386	java/lang/Object
    //   139: invokestatic 830	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: aconst_null
    //   143: astore_0
    //   144: goto -84 -> 60
    //   147: astore_0
    //   148: ldc 255
    //   150: aload_0
    //   151: ldc 231
    //   153: iconst_0
    //   154: anewarray 386	java/lang/Object
    //   157: invokestatic 830	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  private boolean oT(String paramString)
  {
    AppMethodBeat.i(12891);
    if (bt.nullAsNil(u.aqG()).equals(paramString))
    {
      AppMethodBeat.o(12891);
      return true;
    }
    Object localObject = com.tencent.mm.model.q.rW(this.fss);
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
  
  private void oY(final String paramString)
  {
    AppMethodBeat.i(12884);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(12884);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramString);
    paramString = com.tencent.mm.roomsdk.a.b.aEI(this.fss).a(this.fss, localLinkedList, 0);
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
    setMMTitle(this.mTitle + "(" + this.ftI + ")");
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
    this.fvK = ((MMEditText)findViewById(2131302626));
    this.fvo = ((GridView)findViewById(2131297966));
    this.fvo.setNumColumns(bS(this));
    this.fvo.setColumnWidth(getResources().getDimensionPixelSize(2131165489));
    com.tencent.mm.storage.w localw = this.fql;
    String str = this.fss;
    Object localObject = new LinkedList();
    if (!bt.isNullOrNil(this.fvG)) {
      localObject = bt.S(this.fvG.split(","));
    }
    br localbr = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apU().agP("@t.qq.com");
    if (localbr != null) {
      ((List)localObject).add(localbr.name);
    }
    this.fvF = new b(this, localw, str, (List)localObject, this.ftJ);
    this.fvK.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(12860);
        SeeRoomMemberUI.c(SeeRoomMemberUI.this).pa(paramAnonymousCharSequence.toString());
        AppMethodBeat.o(12860);
      }
    });
    this.fvo.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(12861);
        paramAnonymousAdapterView = SeeRoomMemberUI.c(SeeRoomMemberUI.this).kP(paramAnonymousInt);
        if (paramAnonymousAdapterView.type == 2)
        {
          ad.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Add member");
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(219L, 6L, 1L, true);
          SeeRoomMemberUI.d(SeeRoomMemberUI.this);
          AppMethodBeat.o(12861);
          return;
        }
        if (paramAnonymousAdapterView.type == 3)
        {
          ad.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Delete member");
          SeeRoomMemberUI.e(SeeRoomMemberUI.this);
          AppMethodBeat.o(12861);
          return;
        }
        String str;
        if (paramAnonymousAdapterView.type == 1)
        {
          paramAnonymousAdapterView = SeeRoomMemberUI.c(SeeRoomMemberUI.this).kP(paramAnonymousInt).contact;
          if (paramAnonymousAdapterView == null)
          {
            ad.e("MicroMsg.SeeRoomMemberUI", "cont is null");
            AppMethodBeat.o(12861);
            return;
          }
          SeeRoomMemberUI.a(SeeRoomMemberUI.this, paramAnonymousAdapterView.field_username);
          paramAnonymousView = paramAnonymousAdapterView.field_nickname;
          str = SeeRoomMemberUI.a(SeeRoomMemberUI.f(SeeRoomMemberUI.this), SeeRoomMemberUI.g(SeeRoomMemberUI.this));
          if (!bt.isNullOrNil(str)) {
            break label238;
          }
          SeeRoomMemberUI.b(SeeRoomMemberUI.this, paramAnonymousAdapterView.ZX());
        }
        for (;;)
        {
          ac.u(SeeRoomMemberUI.h(SeeRoomMemberUI.this).getText().toString(), 1, 6, paramAnonymousInt + 1);
          SeeRoomMemberUI.a(SeeRoomMemberUI.this, SeeRoomMemberUI.g(SeeRoomMemberUI.this), SeeRoomMemberUI.i(SeeRoomMemberUI.this), paramAnonymousView);
          AppMethodBeat.o(12861);
          return;
          label238:
          SeeRoomMemberUI.b(SeeRoomMemberUI.this, str);
        }
      }
    });
    this.fvo.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(12863);
        if (SeeRoomMemberUI.j(SeeRoomMemberUI.this))
        {
          paramAnonymousAdapterView = SeeRoomMemberUI.c(SeeRoomMemberUI.this).kP(paramAnonymousInt).contact;
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
          ad.i("MicroMsg.SeeRoomMemberUI", "U are not a roomowner");
        }
      }
    });
    this.fvo.setAdapter(this.fvF);
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
      if ((com.tencent.mm.model.w.sm(this.fss)) && (!com.tencent.mm.model.w.sp(this.fss)) && (!com.tencent.mm.model.p.rK(str)))
      {
        com.tencent.mm.ui.base.h.c(this, getString(2131762644), getString(2131755906), true);
        AppMethodBeat.o(12886);
        return;
      }
      if (oT(str))
      {
        com.tencent.mm.ui.base.h.c(this, getString(2131755154), getString(2131755906), true);
        AppMethodBeat.o(12886);
        return;
      }
      if (bt.S(str.split(",")) == null)
      {
        AppMethodBeat.o(12886);
        return;
      }
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      com.tencent.mm.storage.w localw = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV().tH(this.fss);
      if (localw != null)
      {
        if (localw.eKq() == 2)
        {
          new f.a(this).aMo(getString(2131762554)).aMs(getString(2131755884)).wZ(true).p(Boolean.TRUE).aMt(getString(2131755691)).aMq(getString(2131762208)).c(new f.c()
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
        g(str, null, 2131755168);
        AppMethodBeat.o(12886);
        return;
        if (paramIntent == null)
        {
          AppMethodBeat.o(12886);
          return;
        }
        oY(paramIntent.getStringExtra("Select_Contact"));
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(12878);
    super.onConfigurationChanged(paramConfiguration);
    this.fvo.setNumColumns(bS(this));
    AppMethodBeat.o(12878);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12876);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(219L, 2L, 1L, true);
    com.tencent.mm.kernel.g.afA().gcy.a(990, this);
    this.fss = getIntent().getStringExtra("RoomInfo_Id");
    this.talker = getIntent().getStringExtra("Chat_User");
    this.fvH = getIntent().getStringExtra("Chatroom_member_list");
    this.dph = getIntent().getBooleanExtra("Is_Chatroom", true);
    this.fpQ = getIntent().getBooleanExtra("Is_Lbsroom", false);
    this.ftK = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.ftJ = getIntent().getStringExtra("room_owner_name");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    aj localaj = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).apV();
    if (this.talker == null)
    {
      paramBundle = this.fss;
      this.fql = localaj.tH(paramBundle);
      this.ftI = getIntent().getIntExtra("room_member_count", 0);
      this.ftH = getIntent().getStringExtra("room_name");
      this.LZ = getIntent().getIntExtra("offset", 0);
      this.fvL = getIntent().getIntExtra("first_pos", 0);
      initView();
      if (this.fvF != null)
      {
        VQ();
        paramBundle = this.fvo;
        if (this.fvL * fvM >= this.fvF.getCount()) {
          break label335;
        }
      }
    }
    label335:
    for (int i = this.fvL * fvM;; i = this.fvF.getCount() - 1)
    {
      paramBundle.setSelection(i);
      this.fvo.postDelayed(new Runnable()
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
    com.tencent.mm.kernel.g.afA().gcy.b(990, this);
    if ((this.ftP != null) && (this.ftP.isShowing())) {
      this.ftP.dismiss();
    }
    super.onDestroy();
    AppMethodBeat.o(12883);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(12882);
    super.onPause();
    if (this.fvI != null) {
      this.fvI.fdW();
    }
    AppMethodBeat.o(12882);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12877);
    super.onResume();
    if (this.fvF != null) {
      this.fvF.pa(this.fvK.getText().toString());
    }
    AppMethodBeat.o(12877);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(12885);
    if ((this.ftP != null) && (this.ftP.isShowing())) {
      this.ftP.dismiss();
    }
    paramString = com.tencent.mm.h.a.oG(paramString);
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
    af contact;
    int order = 0;
    int type;
    
    public a(int paramInt)
    {
      this.type = paramInt;
      this.contact = null;
    }
    
    public a(af paramaf, int paramInt)
    {
      this.type = 1;
      this.contact = paramaf;
      this.order = paramInt;
    }
  }
  
  final class b
    extends BaseAdapter
  {
    private List<SeeRoomMemberUI.a> dqB;
    private com.tencent.mm.storage.w fql;
    private List<String> fvP;
    public String fvQ;
    private boolean fvR;
    private String fvS;
    private List<SeeRoomMemberUI.a> fvT;
    private com.tencent.mm.plugin.messenger.foundation.a.k fvU;
    private Context mContext;
    private String roomId;
    
    public b(com.tencent.mm.storage.w paramw, String paramString1, List<String> paramList, String paramString2)
    {
      AppMethodBeat.i(12868);
      this.fvR = false;
      this.fvS = null;
      this.dqB = new ArrayList();
      this.fql = paramString1;
      this.roomId = paramList;
      this.fvP = paramString2;
      Object localObject;
      this.fvS = localObject;
      this.mContext = paramw;
      this.fvU = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class));
      aa(com.tencent.mm.model.q.rW(paramList));
      AppMethodBeat.o(12868);
    }
    
    private void oZ(String paramString)
    {
      AppMethodBeat.i(12870);
      ArrayList localArrayList = new ArrayList();
      if (!bt.isNullOrNil(paramString))
      {
        Iterator localIterator = this.fvT.iterator();
        while (localIterator.hasNext())
        {
          SeeRoomMemberUI.a locala = (SeeRoomMemberUI.a)localIterator.next();
          if ((locala != null) && (locala.contact != null) && (locala.type == 1))
          {
            Object localObject = locala.contact;
            if ((((au)localObject).field_conRemark != null) && (((au)localObject).field_conRemark.toUpperCase().contains(paramString.toUpperCase())))
            {
              localArrayList.add(locala);
            }
            else if ((!bt.isNullOrNil(SeeRoomMemberUI.a(this.fql, ((au)localObject).field_username))) && (SeeRoomMemberUI.a(this.fql, ((au)localObject).field_username).contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((af)localObject).ZW() != null) && (((af)localObject).ZW().toUpperCase().contains(paramString.toUpperCase())))
            {
              localArrayList.add(locala);
            }
            else if ((((af)localObject).Sv() != null) && (((af)localObject).Sv().toUpperCase().contains(paramString.toUpperCase())))
            {
              localArrayList.add(locala);
            }
            else if ((((af)localObject).Ss() != null) && (((af)localObject).Ss().contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((au)localObject).field_username != null) && (((au)localObject).field_username.contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if (!com.tencent.mm.n.b.ls(((au)localObject).field_type))
            {
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apN().agQ(((au)localObject).field_username);
              if ((localObject != null) && (((bw)localObject).field_conRemark != null) && (((bw)localObject).field_conRemark.toUpperCase().contains(paramString.toUpperCase()))) {
                localArrayList.add(locala);
              }
            }
          }
        }
        ad.i("MicroMsg.SeeRoomMemberUI", "[setMemberListBySearch]");
      }
      for (this.dqB = localArrayList;; this.dqB = this.fvT)
      {
        notifyDataSetChanged();
        AppMethodBeat.o(12870);
        return;
      }
    }
    
    public final void aa(List<String> paramList)
    {
      AppMethodBeat.i(12869);
      if (paramList == null)
      {
        AppMethodBeat.o(12869);
        return;
      }
      this.dqB.clear();
      int i = 0;
      if (i < paramList.size())
      {
        af localaf = this.fvU.apM().aHY((String)paramList.get(i));
        if (this.fql.ty(localaf.field_username)) {
          this.dqB.add(new SeeRoomMemberUI.a(localaf, 3));
        }
        for (;;)
        {
          i += 1;
          break;
          if (this.fql.aHz(localaf.field_username)) {
            this.dqB.add(new SeeRoomMemberUI.a(localaf, 2));
          } else {
            this.dqB.add(new SeeRoomMemberUI.a(localaf, 1));
          }
        }
      }
      Collections.sort(this.dqB, new Comparator() {});
      this.dqB.add(new SeeRoomMemberUI.a(2));
      if (this.fql.Vq()) {
        this.dqB.add(new SeeRoomMemberUI.a(3));
      }
      this.fvT = this.dqB;
      notifyDataSetChanged();
      AppMethodBeat.o(12869);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(12874);
      int i = this.dqB.size();
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
        localc.frr = ((ImageView)localView.findViewById(2131304481));
        localc.fsI = ((TextView)localView.findViewById(2131304483));
        paramView = (WindowManager)this.mContext.getSystemService("window");
        localc.fsI.setMaxWidth(paramView.getDefaultDisplay().getWidth() * 2 / 3);
        localc.fvW = ((TextView)localView.findViewById(2131304484));
        localView.setTag(localc);
        localc.frr.setTag(Integer.valueOf(paramInt));
        if (localc.fvW != null) {
          localc.fvW.setVisibility(8);
        }
        paramView = (SeeRoomMemberUI.a)this.dqB.get(paramInt);
        if ((paramView == null) || (paramView.type != 1)) {
          break label421;
        }
        af localaf = paramView.contact;
        a.b.c(localc.frr, localaf.field_username);
        str = SeeRoomMemberUI.a(this.fql, localaf.field_username);
        if (bt.isNullOrNil(localaf.field_conRemark)) {
          break label394;
        }
        paramViewGroup = localaf.field_conRemark;
        label228:
        paramView = paramViewGroup;
        if (bt.isNullOrNil(paramViewGroup)) {
          paramView = localaf.ZW();
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
        localc.fsI.setVisibility(0);
        localc.fsI.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, paramViewGroup, localc.fsI.getTextSize()));
        if (localc.fvW != null)
        {
          paramView = com.tencent.mm.openim.room.a.a.G(localaf);
          if (!TextUtils.isEmpty(paramView)) {
            break label400;
          }
          localc.fvW.setVisibility(8);
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
        localc.fvW.setVisibility(0);
        localc.fvW.setText(paramView);
        continue;
        label421:
        if ((paramView != null) && (paramView.type == 2))
        {
          localc.fsI.setVisibility(4);
          localc.frr.setImageResource(2131231164);
        }
        else if ((paramView != null) && (paramView.type == 3))
        {
          localc.fsI.setVisibility(4);
          localc.frr.setImageResource(2131231165);
        }
      }
    }
    
    public final SeeRoomMemberUI.a kP(int paramInt)
    {
      AppMethodBeat.i(12871);
      SeeRoomMemberUI.a locala = (SeeRoomMemberUI.a)this.dqB.get(paramInt);
      AppMethodBeat.o(12871);
      return locala;
    }
    
    public final void pa(String paramString)
    {
      AppMethodBeat.i(12873);
      this.fvR = true;
      this.fvQ = paramString;
      oZ(paramString);
      AppMethodBeat.o(12873);
    }
  }
  
  static final class c
  {
    public ImageView frr;
    public TextView fsI;
    public TextView fvW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomMemberUI
 * JD-Core Version:    0.7.0.1
 */