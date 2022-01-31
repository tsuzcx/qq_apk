package com.tencent.mm.chatroom.ui;

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
import com.tencent.mm.ah.f;
import com.tencent.mm.m.e;
import com.tencent.mm.model.af;
import com.tencent.mm.model.l;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.n;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.e.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SeeRoomMemberUI
  extends MMActivity
  implements f
{
  private static int drr = 5;
  private int El;
  private boolean bRz;
  private u dnL;
  private boolean dno;
  private boolean dpA;
  private com.tencent.mm.ui.base.p dpF;
  private String dpj;
  private String dpx;
  private int dpy;
  private String dpz;
  private GridView dqY;
  private SeeRoomMemberUI.b drk;
  private String drl;
  private String drm;
  private n drn;
  private String dro;
  private MMEditText drp;
  private int drq;
  private String mTitle;
  private String talker;
  private String username;
  
  private static List<String> F(List<String> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    if (!com.tencent.mm.kernel.g.DK()) {
      return localLinkedList;
    }
    if (paramList == null) {
      return localLinkedList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(str);
      paramList = str;
      if (localad != null)
      {
        paramList = str;
        if ((int)localad.dBe != 0) {
          paramList = localad.Bq();
        }
      }
      localLinkedList.add(paramList);
    }
    return localLinkedList;
  }
  
  protected static String a(u paramu, String paramString)
  {
    if (paramu == null) {
      return "";
    }
    return paramu.gV(paramString);
  }
  
  private static int bb(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    int i = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
    int j = (int)(paramContext.getResources().getDimension(a.c.MiddlePadding) * 2.0F + paramContext.getResources().getDimension(a.c.NormalAvatarSize));
    i = (int)((i - paramContext.getResources().getDimension(a.c.ListPadding) * 1.0F) / j);
    y.i("MicroMsg.SeeRoomMemberUI", "[getWrapColNum] :%s", new Object[] { Integer.valueOf(i) });
    drr = i;
    return i;
  }
  
  private void c(final String paramString1, String paramString2, int paramInt)
  {
    if (!l.gA(paramString1)) {
      com.tencent.mm.ui.base.h.b(this, getString(a.i.room_member_only_support_weixin), getString(a.i.app_tip), true);
    }
    do
    {
      return;
      if (eS(paramString1))
      {
        com.tencent.mm.ui.base.h.b(this, getString(a.i.add_room_mem_memberExits), getString(a.i.app_tip), true);
        return;
      }
      paramString1 = bk.G(paramString1.split(","));
    } while (paramString1 == null);
    paramString1 = com.tencent.mm.roomsdk.a.b.YK(this.dpj).a(this.dpj, paramString1, paramString2);
    paramString1.d(new SeeRoomMemberUI.2(this));
    getString(a.i.app_tip);
    paramString1.a(this, getString(paramInt), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        paramString1.cancel();
      }
    });
  }
  
  private void d(String paramString, List<String> paramList)
  {
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
      l.a(paramString, localLinkedList, getString(a.i.chatroom_sys_msg_invite_error_tip), true, paramList);
    }
  }
  
  private void eR(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramString);
    paramString = com.tencent.mm.roomsdk.a.b.YK(this.dpj).a(this.dpj, localLinkedList, 0);
    paramString.b(new SeeRoomMemberUI.15(this));
    paramString.c(new SeeRoomMemberUI.16(this));
    getString(a.i.app_tip);
    paramString.a(this, getString(a.i.room_del_member), true, new SeeRoomMemberUI.17(this, paramString));
  }
  
  private boolean eS(String paramString)
  {
    if (bk.pm(q.Gj()).equals(paramString)) {
      return true;
    }
    Object localObject = com.tencent.mm.model.m.gK(this.dpj);
    if (localObject == null) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    boolean bool = false;
    if (((Iterator)localObject).hasNext())
    {
      if (!((String)((Iterator)localObject).next()).equals(paramString)) {
        break label70;
      }
      bool = true;
    }
    label70:
    for (;;)
    {
      break;
      return bool;
    }
  }
  
  /* Error */
  private static Object invokeMethod(Object paramObject, String paramString, Object[] paramArrayOfObject, java.lang.Class[] paramArrayOfClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: invokevirtual 836	java/lang/Object:getClass	()Ljava/lang/Class;
    //   10: astore 4
    //   12: aload 4
    //   14: ldc_w 342
    //   17: if_acmpeq +130 -> 147
    //   20: aload 4
    //   22: aload_1
    //   23: aload_3
    //   24: invokevirtual 842	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   27: astore 5
    //   29: aload 5
    //   31: astore_1
    //   32: aload_1
    //   33: ifnull +109 -> 142
    //   36: aload_1
    //   37: iconst_1
    //   38: invokevirtual 848	java/lang/reflect/Method:setAccessible	(Z)V
    //   41: aload_1
    //   42: aload_0
    //   43: aload_2
    //   44: invokevirtual 852	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   47: astore_0
    //   48: aload_0
    //   49: areturn
    //   50: astore 5
    //   52: ldc 156
    //   54: aload 5
    //   56: ldc 129
    //   58: iconst_0
    //   59: anewarray 342	java/lang/Object
    //   62: invokestatic 856	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   65: aload 4
    //   67: invokevirtual 859	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   70: astore 4
    //   72: goto -60 -> 12
    //   75: astore 5
    //   77: ldc 156
    //   79: aload 5
    //   81: ldc 129
    //   83: iconst_0
    //   84: anewarray 342	java/lang/Object
    //   87: invokestatic 856	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   90: goto -25 -> 65
    //   93: astore_0
    //   94: ldc 156
    //   96: aload_0
    //   97: ldc 129
    //   99: iconst_0
    //   100: anewarray 342	java/lang/Object
    //   103: invokestatic 856	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: aconst_null
    //   107: astore_0
    //   108: goto -60 -> 48
    //   111: astore_0
    //   112: ldc 156
    //   114: aload_0
    //   115: ldc 129
    //   117: iconst_0
    //   118: anewarray 342	java/lang/Object
    //   121: invokestatic 856	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: aconst_null
    //   125: astore_0
    //   126: goto -78 -> 48
    //   129: astore_0
    //   130: ldc 156
    //   132: aload_0
    //   133: ldc 129
    //   135: iconst_0
    //   136: anewarray 342	java/lang/Object
    //   139: invokestatic 856	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: aconst_null
    //   143: astore_0
    //   144: goto -96 -> 48
    //   147: aconst_null
    //   148: astore_1
    //   149: goto -117 -> 32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	paramObject	Object
    //   0	152	1	paramString	String
    //   0	152	2	paramArrayOfObject	Object[]
    //   0	152	3	paramArrayOfClass	java.lang.Class[]
    //   10	61	4	localClass	java.lang.Class
    //   27	3	5	localMethod	java.lang.reflect.Method
    //   50	5	5	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   75	5	5	localSecurityException	java.lang.SecurityException
    // Exception table:
    //   from	to	target	type
    //   20	29	50	java/lang/NoSuchMethodException
    //   20	29	75	java/lang/SecurityException
    //   41	48	93	java/lang/IllegalAccessException
    //   41	48	111	java/lang/IllegalArgumentException
    //   41	48	129	java/lang/reflect/InvocationTargetException
  }
  
  private void xP()
  {
    af localaf = ((c)com.tencent.mm.kernel.g.r(c.class)).FF();
    if (this.talker == null) {}
    for (Object localObject = this.dpj;; localObject = this.talker)
    {
      this.dnL = localaf.in((String)localObject);
      localObject = com.tencent.mm.model.m.gK(this.dpj);
      if (this.drk != null) {
        this.drk.G((List)localObject);
      }
      return;
    }
  }
  
  private static boolean xo()
  {
    return bk.getInt(com.tencent.mm.m.g.AA().getValue("ChatroomGlobalSwitch"), 1) == 1;
  }
  
  protected final int getLayoutId()
  {
    return a.f.see_roommember_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(this.mTitle + "(" + this.dpy + ")");
    setBackBtn(new SeeRoomMemberUI.11(this));
    this.drp = ((MMEditText)findViewById(a.e.mutiselectcontact_edittext));
    this.dqY = ((GridView)findViewById(a.e.chatroom_member_gv));
    this.dqY.setNumColumns(bb(this));
    this.dqY.setColumnWidth(getResources().getDimensionPixelSize(a.c.ListPadding));
    u localu = this.dnL;
    String str = this.dpj;
    Object localObject = new LinkedList();
    if (!bk.bl(this.drl)) {
      localObject = bk.G(this.drl.split(","));
    }
    bq localbq = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FE().Ic("@t.qq.com");
    if (localbq != null) {
      ((List)localObject).add(localbq.name);
    }
    this.drk = new SeeRoomMemberUI.b(this, this, localu, str, (List)localObject, this.dpz);
    this.drp.addTextChangedListener(new SeeRoomMemberUI.12(this));
    this.dqY.setOnItemClickListener(new SeeRoomMemberUI.13(this));
    this.dqY.setOnItemLongClickListener(new SeeRoomMemberUI.14(this));
    this.dqY.setAdapter(this.drk);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      Object localObject;
      u localu;
      do
      {
        do
        {
          do
          {
            return;
          } while (paramIntent == null);
          localObject = paramIntent.getStringExtra("Select_Contact");
          if (!l.gA((String)localObject))
          {
            com.tencent.mm.ui.base.h.b(this, getString(a.i.room_member_only_support_weixin), getString(a.i.app_tip), true);
            return;
          }
          if (eS((String)localObject))
          {
            com.tencent.mm.ui.base.h.b(this, getString(a.i.add_room_mem_memberExits), getString(a.i.app_tip), true);
            return;
          }
        } while (bk.G(((String)localObject).split(",")) == null);
        paramIntent = paramIntent.getStringExtra("Select_Contact");
        localu = ((c)com.tencent.mm.kernel.g.r(c.class)).FF().in(this.dpj);
      } while (localu == null);
      if (localu.ctQ() == 2)
      {
        localObject = new e.a(this).aeG(getString(a.i.request_to_owner_tip));
        ((e.a)localObject).wnv = getString(a.i.app_send);
        localObject = ((e.a)localObject).nY(true).l(Boolean.valueOf(true));
        ((e.a)localObject).wnw = getString(a.i.app_cancel);
        ((e.a)localObject).aeH(getString(a.i.reason_invite_hint)).c(new SeeRoomMemberUI.18(this, paramIntent)).show();
        return;
      }
      c((String)localObject, null, a.i.adding_room_mem);
      return;
    } while (paramIntent == null);
    eR(paramIntent.getStringExtra("Select_Contact"));
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.dqY.setNumColumns(bb(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.nFQ.a(219L, 2L, 1L, true);
    com.tencent.mm.kernel.g.DO().dJT.a(990, this);
    this.dpj = getIntent().getStringExtra("RoomInfo_Id");
    this.talker = getIntent().getStringExtra("Chat_User");
    this.drm = getIntent().getStringExtra("Chatroom_member_list");
    this.bRz = getIntent().getBooleanExtra("Is_Chatroom", true);
    this.dno = getIntent().getBooleanExtra("Is_Lbsroom", false);
    this.dpA = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.dpz = getIntent().getStringExtra("room_owner_name");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    af localaf = ((c)com.tencent.mm.kernel.g.r(c.class)).FF();
    if (this.talker == null)
    {
      paramBundle = this.dpj;
      this.dnL = localaf.in(paramBundle);
      this.dpy = getIntent().getIntExtra("room_member_count", 0);
      this.dpx = getIntent().getStringExtra("room_name");
      this.El = getIntent().getIntExtra("offset", 0);
      this.drq = getIntent().getIntExtra("first_pos", 0);
      initView();
      if (this.drk != null)
      {
        xP();
        paramBundle = this.dqY;
        if (this.drq * drr >= this.drk.getCount()) {
          break label324;
        }
      }
    }
    label324:
    for (int i = this.drq * drr;; i = this.drk.getCount() - 1)
    {
      paramBundle.setSelection(i);
      this.dqY.postDelayed(new SeeRoomMemberUI.1(this), 100L);
      return;
      paramBundle = this.talker;
      break;
    }
  }
  
  protected void onDestroy()
  {
    com.tencent.mm.kernel.g.DO().dJT.b(990, this);
    if ((this.dpF != null) && (this.dpF.isShowing())) {
      this.dpF.dismiss();
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.drn != null) {
      this.drn.cJg();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.drk != null) {
      this.drk.eT(this.drp.getText().toString());
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((this.dpF != null) && (this.dpF.isShowing())) {
      this.dpF.dismiss();
    }
    paramString = com.tencent.mm.i.a.eI(paramString);
    if (paramString != null) {
      paramString.a(this, null, null);
    }
  }
  
  private static final class a
  {
    ad dnp;
    int order = 0;
    int type;
    
    public a(int paramInt)
    {
      this.type = paramInt;
      this.dnp = null;
    }
    
    public a(ad paramad, int paramInt)
    {
      this.type = 1;
      this.dnp = paramad;
      this.order = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomMemberUI
 * JD-Core Version:    0.7.0.1
 */