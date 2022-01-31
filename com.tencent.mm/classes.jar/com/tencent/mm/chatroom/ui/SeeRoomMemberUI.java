package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.widget.GridView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.m.e;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.q;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.b.e.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SeeRoomMemberUI
  extends MMActivity
  implements f
{
  private static int eiZ = 5;
  private int Fb;
  private boolean czb;
  private boolean eeO;
  private u efi;
  private String egF;
  private String egT;
  private int egU;
  private String egV;
  private boolean egW;
  private com.tencent.mm.ui.base.p ehb;
  private GridView eiB;
  private SeeRoomMemberUI.b eiS;
  private String eiT;
  private String eiU;
  private q eiV;
  private String eiW;
  private MMEditText eiX;
  private int eiY;
  private String mTitle;
  private String talker;
  private String username;
  
  private static boolean JG()
  {
    AppMethodBeat.i(104348);
    if (bo.getInt(com.tencent.mm.m.g.Nq().getValue("ChatroomGlobalSwitch"), 1) == 1)
    {
      AppMethodBeat.o(104348);
      return true;
    }
    AppMethodBeat.o(104348);
    return false;
  }
  
  private void Kh()
  {
    AppMethodBeat.i(104339);
    ag localag = ((c)com.tencent.mm.kernel.g.E(c.class)).YJ();
    if (this.talker == null) {}
    for (Object localObject = this.egF;; localObject = this.talker)
    {
      this.efi = localag.oU((String)localObject);
      localObject = n.nt(this.egF);
      if (this.eiS != null) {
        this.eiS.N((List)localObject);
      }
      AppMethodBeat.o(104339);
      return;
    }
  }
  
  private static List<String> M(List<String> paramList)
  {
    AppMethodBeat.i(104349);
    LinkedList localLinkedList = new LinkedList();
    if (!com.tencent.mm.kernel.g.RG())
    {
      AppMethodBeat.o(104349);
      return localLinkedList;
    }
    if (paramList == null)
    {
      AppMethodBeat.o(104349);
      return localLinkedList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ad localad = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arw(str);
      paramList = str;
      if (localad != null)
      {
        paramList = str;
        if ((int)localad.euF != 0) {
          paramList = localad.Of();
        }
      }
      localLinkedList.add(paramList);
    }
    AppMethodBeat.o(104349);
    return localLinkedList;
  }
  
  protected static String a(u paramu, String paramString)
  {
    AppMethodBeat.i(104351);
    if (paramu == null)
    {
      AppMethodBeat.o(104351);
      return "";
    }
    paramu = paramu.nE(paramString);
    AppMethodBeat.o(104351);
    return paramu;
  }
  
  private static int bE(Context paramContext)
  {
    AppMethodBeat.i(104337);
    int i = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
    int j = (int)(paramContext.getResources().getDimension(2131427792) * 2.0F + paramContext.getResources().getDimension(2131427800));
    i = (int)((i - paramContext.getResources().getDimension(2131427781) * 1.0F) / j);
    ab.i("MicroMsg.SeeRoomMemberUI", "[getWrapColNum] :%s", new Object[] { Integer.valueOf(i) });
    eiZ = i;
    AppMethodBeat.o(104337);
    return i;
  }
  
  private void d(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(104347);
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
      com.tencent.mm.model.m.a(paramString, localLinkedList, getString(2131298139), true, paramList);
    }
    AppMethodBeat.o(104347);
  }
  
  private void e(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(104346);
    if (!com.tencent.mm.model.m.ni(paramString1))
    {
      com.tencent.mm.ui.base.h.b(this, getString(2131302733), getString(2131297087), true);
      AppMethodBeat.o(104346);
      return;
    }
    if (kX(paramString1))
    {
      com.tencent.mm.ui.base.h.b(this, getString(2131296426), getString(2131297087), true);
      AppMethodBeat.o(104346);
      return;
    }
    paramString1 = bo.P(paramString1.split(","));
    if (paramString1 == null)
    {
      AppMethodBeat.o(104346);
      return;
    }
    paramString1 = com.tencent.mm.roomsdk.a.b.aoI(this.egF).a(this.egF, paramString1, paramString2);
    paramString1.d(new SeeRoomMemberUI.2(this));
    getString(2131297087);
    paramString1.a(this, getString(paramInt), true, new SeeRoomMemberUI.3(this, paramString1));
    AppMethodBeat.o(104346);
  }
  
  /* Error */
  private static Object invokeMethod(Object paramObject, String paramString, Object[] paramArrayOfObject, java.lang.Class[] paramArrayOfClass)
  {
    // Byte code:
    //   0: ldc_w 796
    //   3: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnonnull +11 -> 18
    //   10: ldc_w 796
    //   13: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: aload_0
    //   19: invokevirtual 800	java/lang/Object:getClass	()Ljava/lang/Class;
    //   22: astore 4
    //   24: aload 4
    //   26: ldc_w 358
    //   29: if_acmpeq +136 -> 165
    //   32: aload 4
    //   34: aload_1
    //   35: aload_3
    //   36: invokevirtual 806	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   39: astore 5
    //   41: aload 5
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +115 -> 160
    //   48: aload_1
    //   49: iconst_1
    //   50: invokevirtual 812	java/lang/reflect/Method:setAccessible	(Z)V
    //   53: aload_1
    //   54: aload_0
    //   55: aload_2
    //   56: invokevirtual 816	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   59: astore_0
    //   60: ldc_w 796
    //   63: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_0
    //   67: areturn
    //   68: astore 5
    //   70: ldc 222
    //   72: aload 5
    //   74: ldc 197
    //   76: iconst_0
    //   77: anewarray 358	java/lang/Object
    //   80: invokestatic 820	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aload 4
    //   85: invokevirtual 823	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   88: astore 4
    //   90: goto -66 -> 24
    //   93: astore 5
    //   95: ldc 222
    //   97: aload 5
    //   99: ldc 197
    //   101: iconst_0
    //   102: anewarray 358	java/lang/Object
    //   105: invokestatic 820	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: goto -25 -> 83
    //   111: astore_0
    //   112: ldc 222
    //   114: aload_0
    //   115: ldc 197
    //   117: iconst_0
    //   118: anewarray 358	java/lang/Object
    //   121: invokestatic 820	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: aconst_null
    //   125: astore_0
    //   126: goto -66 -> 60
    //   129: astore_0
    //   130: ldc 222
    //   132: aload_0
    //   133: ldc 197
    //   135: iconst_0
    //   136: anewarray 358	java/lang/Object
    //   139: invokestatic 820	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: aconst_null
    //   143: astore_0
    //   144: goto -84 -> 60
    //   147: astore_0
    //   148: ldc 222
    //   150: aload_0
    //   151: ldc 197
    //   153: iconst_0
    //   154: anewarray 358	java/lang/Object
    //   157: invokestatic 820	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   0	170	3	paramArrayOfClass	java.lang.Class[]
    //   22	67	4	localClass	java.lang.Class
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
  
  private boolean kX(String paramString)
  {
    AppMethodBeat.i(104350);
    if (bo.nullAsNil(r.Zn()).equals(paramString))
    {
      AppMethodBeat.o(104350);
      return true;
    }
    Object localObject = n.nt(this.egF);
    if (localObject == null)
    {
      AppMethodBeat.o(104350);
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
      AppMethodBeat.o(104350);
      return bool;
    }
  }
  
  private void lc(String paramString)
  {
    AppMethodBeat.i(104343);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(104343);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramString);
    paramString = com.tencent.mm.roomsdk.a.b.aoI(this.egF).a(this.egF, localLinkedList, 0);
    paramString.b(new SeeRoomMemberUI.15(this));
    paramString.c(new SeeRoomMemberUI.16(this));
    getString(2131297087);
    paramString.a(this, getString(2131302684), true, new SeeRoomMemberUI.17(this, paramString));
    AppMethodBeat.o(104343);
  }
  
  public int getLayoutId()
  {
    return 2130970642;
  }
  
  public void initView()
  {
    AppMethodBeat.i(104338);
    setMMTitle(this.mTitle + "(" + this.egU + ")");
    setBackBtn(new SeeRoomMemberUI.11(this));
    this.eiX = ((MMEditText)findViewById(2131823364));
    this.eiB = ((GridView)findViewById(2131827528));
    this.eiB.setNumColumns(bE(this));
    this.eiB.setColumnWidth(getResources().getDimensionPixelSize(2131427781));
    u localu = this.efi;
    String str = this.egF;
    Object localObject = new LinkedList();
    if (!bo.isNullOrNil(this.eiT)) {
      localObject = bo.P(this.eiT.split(","));
    }
    bq localbq = ((j)com.tencent.mm.kernel.g.E(j.class)).YI().TL("@t.qq.com");
    if (localbq != null) {
      ((List)localObject).add(localbq.name);
    }
    this.eiS = new SeeRoomMemberUI.b(this, this, localu, str, (List)localObject, this.egV);
    this.eiX.addTextChangedListener(new SeeRoomMemberUI.12(this));
    this.eiB.setOnItemClickListener(new SeeRoomMemberUI.13(this));
    this.eiB.setOnItemLongClickListener(new SeeRoomMemberUI.14(this));
    this.eiB.setAdapter(this.eiS);
    AppMethodBeat.o(104338);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(104345);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(104345);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(104345);
        return;
      }
      Object localObject = paramIntent.getStringExtra("Select_Contact");
      if (!com.tencent.mm.model.m.ni((String)localObject))
      {
        com.tencent.mm.ui.base.h.b(this, getString(2131302733), getString(2131297087), true);
        AppMethodBeat.o(104345);
        return;
      }
      if (kX((String)localObject))
      {
        com.tencent.mm.ui.base.h.b(this, getString(2131296426), getString(2131297087), true);
        AppMethodBeat.o(104345);
        return;
      }
      if (bo.P(((String)localObject).split(",")) == null)
      {
        AppMethodBeat.o(104345);
        return;
      }
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      u localu = ((c)com.tencent.mm.kernel.g.E(c.class)).YJ().oU(this.egF);
      if (localu != null)
      {
        if (localu.dwq() == 2)
        {
          localObject = new e.a(this).avu(getString(2131302647));
          ((e.a)localObject).AHs = getString(2131297067);
          localObject = ((e.a)localObject).rI(true).n(Boolean.TRUE);
          ((e.a)localObject).AHt = getString(2131296888);
          ((e.a)localObject).avw(getString(2131302327)).c(new SeeRoomMemberUI.18(this, paramIntent)).show();
          AppMethodBeat.o(104345);
          return;
        }
        e((String)localObject, null, 2131296440);
        AppMethodBeat.o(104345);
        return;
        if (paramIntent == null)
        {
          AppMethodBeat.o(104345);
          return;
        }
        lc(paramIntent.getStringExtra("Select_Contact"));
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(104336);
    super.onConfigurationChanged(paramConfiguration);
    this.eiB.setNumColumns(bE(this));
    AppMethodBeat.o(104336);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104334);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(219L, 2L, 1L, true);
    com.tencent.mm.kernel.g.RK().eHt.a(990, this);
    this.egF = getIntent().getStringExtra("RoomInfo_Id");
    this.talker = getIntent().getStringExtra("Chat_User");
    this.eiU = getIntent().getStringExtra("Chatroom_member_list");
    this.czb = getIntent().getBooleanExtra("Is_Chatroom", true);
    this.eeO = getIntent().getBooleanExtra("Is_Lbsroom", false);
    this.egW = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.egV = getIntent().getStringExtra("room_owner_name");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    ag localag = ((c)com.tencent.mm.kernel.g.E(c.class)).YJ();
    if (this.talker == null)
    {
      paramBundle = this.egF;
      this.efi = localag.oU(paramBundle);
      this.egU = getIntent().getIntExtra("room_member_count", 0);
      this.egT = getIntent().getStringExtra("room_name");
      this.Fb = getIntent().getIntExtra("offset", 0);
      this.eiY = getIntent().getIntExtra("first_pos", 0);
      initView();
      if (this.eiS != null)
      {
        Kh();
        paramBundle = this.eiB;
        if (this.eiY * eiZ >= this.eiS.getCount()) {
          break label335;
        }
      }
    }
    label335:
    for (int i = this.eiY * eiZ;; i = this.eiS.getCount() - 1)
    {
      paramBundle.setSelection(i);
      this.eiB.postDelayed(new SeeRoomMemberUI.1(this), 100L);
      AppMethodBeat.o(104334);
      return;
      paramBundle = this.talker;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104341);
    com.tencent.mm.kernel.g.RK().eHt.b(990, this);
    if ((this.ehb != null) && (this.ehb.isShowing())) {
      this.ehb.dismiss();
    }
    super.onDestroy();
    AppMethodBeat.o(104341);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(104340);
    super.onPause();
    if (this.eiV != null) {
      this.eiV.dNV();
    }
    AppMethodBeat.o(104340);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(104335);
    super.onResume();
    if (this.eiS != null) {
      this.eiS.le(this.eiX.getText().toString());
    }
    AppMethodBeat.o(104335);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(104344);
    if ((this.ehb != null) && (this.ehb.isShowing())) {
      this.ehb.dismiss();
    }
    paramString = com.tencent.mm.h.a.kO(paramString);
    if (paramString != null)
    {
      paramString.a(this, null, null);
      AppMethodBeat.o(104344);
      return;
    }
    AppMethodBeat.o(104344);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomMemberUI
 * JD-Core Version:    0.7.0.1
 */