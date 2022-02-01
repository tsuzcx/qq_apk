package com.tencent.mm.chatroom.ui;

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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cm;
import com.tencent.mm.storage.cr;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SeeRoomMemberUI
  extends MMActivity
  implements com.tencent.mm.am.h, com.tencent.mm.chatroom.g.a.b
{
  private static int lMA = 5;
  private int Sc;
  private boolean hQu;
  private String lKh;
  private int lKi;
  private String lKj;
  private boolean lKk;
  private w lKp;
  private AdapterView.OnItemClickListener lMB;
  private GridView lMd;
  private b lMt;
  private String lMu;
  private String lMv;
  private com.tencent.mm.ui.tools.s lMw;
  private String lMx;
  private MMEditText lMy;
  private int lMz;
  private String lyn;
  private boolean lzS;
  private com.tencent.mm.storage.aj lzy;
  private String mTitle;
  private String talker;
  private String username;
  
  public SeeRoomMemberUI()
  {
    AppMethodBeat.i(241749);
    this.lMB = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(241786);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        if (paramAnonymousInt > SeeRoomMemberUI.c(SeeRoomMemberUI.this).getCount() - 1)
        {
          Log.i("MicroMsg.SeeRoomMemberUI", "[onItemClick]count=%s position=%s", new Object[] { Integer.valueOf(SeeRoomMemberUI.c(SeeRoomMemberUI.this).getCount()), Integer.valueOf(paramAnonymousInt) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(241786);
          return;
        }
        paramAnonymousAdapterView = SeeRoomMemberUI.c(SeeRoomMemberUI.this).qE(paramAnonymousInt);
        if (paramAnonymousAdapterView.type == 2)
        {
          Log.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Add member");
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(219L, 6L, 1L, true);
          SeeRoomMemberUI.f(SeeRoomMemberUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(241786);
          return;
        }
        if (paramAnonymousAdapterView.type == 3)
        {
          Log.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Delete member");
          SeeRoomMemberUI.g(SeeRoomMemberUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(241786);
          return;
        }
        if (paramAnonymousAdapterView.type == 1)
        {
          paramAnonymousAdapterView = SeeRoomMemberUI.c(SeeRoomMemberUI.this).qE(paramAnonymousInt).contact;
          if (paramAnonymousAdapterView == null)
          {
            Log.e("MicroMsg.SeeRoomMemberUI", "cont is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(241786);
            return;
          }
          SeeRoomMemberUI.a(SeeRoomMemberUI.this, paramAnonymousAdapterView.field_username);
          paramAnonymousView = paramAnonymousAdapterView.field_nickname;
          localObject = SeeRoomMemberUI.a(SeeRoomMemberUI.e(SeeRoomMemberUI.this), SeeRoomMemberUI.h(SeeRoomMemberUI.this));
          if (!Util.isNullOrNil((String)localObject)) {
            break label400;
          }
          SeeRoomMemberUI.b(SeeRoomMemberUI.this, paramAnonymousAdapterView.aSV());
        }
        for (;;)
        {
          com.tencent.mm.ui.contact.aj.y(SeeRoomMemberUI.i(SeeRoomMemberUI.this).getText().toString(), 1, 6, paramAnonymousInt + 1);
          SeeRoomMemberUI.a(SeeRoomMemberUI.this, SeeRoomMemberUI.h(SeeRoomMemberUI.this), SeeRoomMemberUI.j(SeeRoomMemberUI.this), paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(241786);
          return;
          label400:
          SeeRoomMemberUI.b(SeeRoomMemberUI.this, (String)localObject);
        }
      }
    };
    AppMethodBeat.o(241749);
  }
  
  private void Dk(final String paramString)
  {
    AppMethodBeat.i(12884);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(12884);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramString);
    paramString = com.tencent.mm.roomsdk.model.b.btW(this.lyn).a(this.lyn, localLinkedList, 0);
    paramString.b(new com.tencent.mm.roomsdk.model.b.b()
    {
      public final void onResult(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.roomsdk.model.b.b paramAnonymousb)
      {
        AppMethodBeat.i(241783);
        SeeRoomMemberUI.this.aMd();
        SeeRoomMemberUI.this.aMe();
        AppMethodBeat.o(241783);
      }
    });
    paramString.c(new com.tencent.mm.roomsdk.model.b.b()
    {
      public final void onResult(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.roomsdk.model.b.b paramAnonymousb)
      {
        AppMethodBeat.i(241787);
        paramAnonymousString = com.tencent.mm.broadcast.a.CH(paramAnonymousString);
        if (paramAnonymousString != null)
        {
          paramAnonymousString.a(SeeRoomMemberUI.this, null, null);
          AppMethodBeat.o(241787);
          return;
        }
        if (paramAnonymousInt2 == -66)
        {
          k.c(SeeRoomMemberUI.this, SeeRoomMemberUI.this.getString(a.i.lHv), SeeRoomMemberUI.this.getString(a.i.app_tip), true);
          SeeRoomMemberUI.this.aMd();
          SeeRoomMemberUI.this.aMe();
        }
        AppMethodBeat.o(241787);
      }
    });
    paramString.a(this, getString(a.i.app_tip), getString(a.i.gTw), true, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(241780);
        paramString.cancel();
        AppMethodBeat.o(241780);
      }
    });
    AppMethodBeat.o(12884);
  }
  
  protected static String a(com.tencent.mm.storage.aj paramaj, String paramString)
  {
    AppMethodBeat.i(12892);
    if (paramaj == null)
    {
      AppMethodBeat.o(12892);
      return "";
    }
    paramaj = paramaj.getDisplayName(paramString);
    AppMethodBeat.o(12892);
    return paramaj;
  }
  
  private static int da(Context paramContext)
  {
    AppMethodBeat.i(12879);
    int i = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
    int j = (int)(paramContext.getResources().getDimension(a.c.MiddlePadding) * 2.0F + paramContext.getResources().getDimension(a.c.NormalAvatarSize));
    i = (int)((i - paramContext.getResources().getDimension(a.c.ListPadding) * 1.0F) / j);
    Log.i("MicroMsg.SeeRoomMemberUI", "[getWrapColNum] :%s", new Object[] { Integer.valueOf(i) });
    lMA = i;
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
    //   19: invokevirtual 575	java/lang/Object:getClass	()Ljava/lang/Class;
    //   22: astore 4
    //   24: aload 4
    //   26: ldc_w 461
    //   29: if_acmpeq +136 -> 165
    //   32: aload 4
    //   34: aload_1
    //   35: aload_3
    //   36: invokevirtual 581	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   39: astore 5
    //   41: aload 5
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +115 -> 160
    //   48: aload_1
    //   49: iconst_1
    //   50: invokevirtual 587	java/lang/reflect/Method:setAccessible	(Z)V
    //   53: aload_1
    //   54: aload_0
    //   55: aload_2
    //   56: invokevirtual 591	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
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
    //   77: anewarray 461	java/lang/Object
    //   80: invokestatic 595	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: aload 4
    //   85: invokevirtual 598	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   88: astore 4
    //   90: goto -66 -> 24
    //   93: astore 5
    //   95: ldc 196
    //   97: aload 5
    //   99: ldc 103
    //   101: iconst_0
    //   102: anewarray 461	java/lang/Object
    //   105: invokestatic 595	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: goto -25 -> 83
    //   111: astore_0
    //   112: ldc 196
    //   114: aload_0
    //   115: ldc 103
    //   117: iconst_0
    //   118: anewarray 461	java/lang/Object
    //   121: invokestatic 595	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: aconst_null
    //   125: astore_0
    //   126: goto -66 -> 60
    //   129: astore_0
    //   130: ldc 196
    //   132: aload_0
    //   133: ldc 103
    //   135: iconst_0
    //   136: anewarray 461	java/lang/Object
    //   139: invokestatic 595	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: aconst_null
    //   143: astore_0
    //   144: goto -84 -> 60
    //   147: astore_0
    //   148: ldc 196
    //   150: aload_0
    //   151: ldc 103
    //   153: iconst_0
    //   154: anewarray 461	java/lang/Object
    //   157: invokestatic 595	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  public final void aMd()
  {
    AppMethodBeat.i(12881);
    ar localar = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK();
    if (this.talker == null) {}
    for (String str = this.lyn;; str = this.talker)
    {
      this.lzy = localar.Ju(str);
      runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(241781);
          if (SeeRoomMemberUI.c(SeeRoomMemberUI.this) != null) {
            SeeRoomMemberUI.c(SeeRoomMemberUI.this).bv(this.lME);
          }
          AppMethodBeat.o(241781);
        }
      });
      AppMethodBeat.o(12881);
      return;
    }
  }
  
  public final void aMe()
  {
    AppMethodBeat.i(241848);
    if (this.lzy != null) {
      setMMTitle(this.mTitle + "(" + this.lzy.bHw().size() + ")");
    }
    AppMethodBeat.o(241848);
  }
  
  public int getLayoutId()
  {
    return a.f.lGy;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12880);
    setMMTitle(this.mTitle + "(" + this.lKi + ")");
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
    this.lMy = ((MMEditText)findViewById(a.e.mutiselectcontact_edittext));
    this.lMd = ((GridView)findViewById(a.e.lEv));
    this.lMd.setNumColumns(da(this));
    this.lMd.setColumnWidth(getResources().getDimensionPixelSize(a.c.ListPadding));
    com.tencent.mm.storage.aj localaj = this.lzy;
    String str = this.lyn;
    Object localObject = new LinkedList();
    if (!Util.isNullOrNil(this.lMu)) {
      localObject = Util.stringsToList(this.lMu.split(","));
    }
    cm localcm = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzJ().aMh("@t.qq.com");
    if (localcm != null) {
      ((List)localObject).add(localcm.name);
    }
    this.lMt = new b(this, localaj, str, (List)localObject, this.lKj);
    this.lMy.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(12860);
        SeeRoomMemberUI.c(SeeRoomMemberUI.this).Dm(paramAnonymousCharSequence.toString());
        AppMethodBeat.o(12860);
      }
    });
    this.lMd.setOnItemClickListener(this.lMB);
    this.lMd.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(241788);
        if (SeeRoomMemberUI.d(SeeRoomMemberUI.this))
        {
          paramAnonymousAdapterView = SeeRoomMemberUI.c(SeeRoomMemberUI.this).qE(paramAnonymousInt).contact;
          if (paramAnonymousAdapterView == null)
          {
            AppMethodBeat.o(241788);
            return true;
          }
          paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
          if (SeeRoomMemberUI.e(SeeRoomMemberUI.this).field_roomowner.equals(paramAnonymousAdapterView))
          {
            AppMethodBeat.o(241788);
            return true;
          }
          k.a(SeeRoomMemberUI.this, SeeRoomMemberUI.this.getString(a.i.lIh), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(241690);
              SeeRoomMemberUI.a(SeeRoomMemberUI.this, paramAnonymousInt);
              AppMethodBeat.o(241690);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          });
        }
        for (;;)
        {
          AppMethodBeat.o(241788);
          return true;
          Log.i("MicroMsg.SeeRoomMemberUI", "U are not a roomowner");
        }
      }
    });
    this.lMd.setAdapter(this.lMt);
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
      if ((au.bwG(this.lyn)) && (!ab.II(this.lyn)) && (!u.HZ(str)))
      {
        k.c(this, getString(a.i.lIz), getString(a.i.app_tip), true);
        AppMethodBeat.o(12886);
        return;
      }
      if (Util.nullAsNil(z.bAM()).equals(str)) {
        paramInt1 = 1;
      }
      for (;;)
      {
        label150:
        if (paramInt1 != 0)
        {
          k.c(this, getString(a.i.add_room_mem_memberExits), getString(a.i.app_tip), true);
          AppMethodBeat.o(12886);
          return;
          Object localObject = v.Il(this.lyn);
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
      new com.tencent.mm.chatroom.g.a(this, this.lyn, str, localLocalHistoryInfo, l, this);
      AppMethodBeat.o(12886);
      return;
      if (paramIntent == null)
      {
        AppMethodBeat.o(12886);
        return;
      }
      Dk(paramIntent.getStringExtra("Select_Contact"));
      break;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(12878);
    super.onConfigurationChanged(paramConfiguration);
    this.lMd.setNumColumns(da(this));
    AppMethodBeat.o(12878);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12876);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(219L, 2L, 1L, true);
    com.tencent.mm.kernel.h.baD().mCm.a(990, this);
    this.lyn = getIntent().getStringExtra("RoomInfo_Id");
    this.talker = getIntent().getStringExtra("Chat_User");
    this.lMv = getIntent().getStringExtra("Chatroom_member_list");
    this.hQu = getIntent().getBooleanExtra("Is_Chatroom", true);
    this.lzS = getIntent().getBooleanExtra("Is_Lbsroom", false);
    this.lKk = getIntent().getBooleanExtra("Is_RoomOwner", false);
    this.lKj = getIntent().getStringExtra("room_owner_name");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    ar localar = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK();
    if (this.talker == null)
    {
      paramBundle = this.lyn;
      this.lzy = localar.Ju(paramBundle);
      this.lKi = getIntent().getIntExtra("room_member_count", 0);
      this.lKh = getIntent().getStringExtra("room_name");
      this.Sc = getIntent().getIntExtra("offset", 0);
      this.lMz = getIntent().getIntExtra("first_pos", 0);
      initView();
      if (this.lMt != null)
      {
        aMd();
        paramBundle = this.lMd;
        if (this.lMz * lMA >= this.lMt.getCount()) {
          break label336;
        }
      }
    }
    label336:
    for (int i = this.lMz * lMA;; i = this.lMt.getCount() - 1)
    {
      paramBundle.setSelection(i);
      this.lMd.postDelayed(new Runnable()
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
    com.tencent.mm.kernel.h.baD().mCm.b(990, this);
    if ((this.lKp != null) && (this.lKp.isShowing())) {
      this.lKp.dismiss();
    }
    super.onDestroy();
    AppMethodBeat.o(12883);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(12882);
    super.onPause();
    if (this.lMw != null) {
      this.lMw.jyO();
    }
    AppMethodBeat.o(12882);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12877);
    super.onResume();
    if (this.lMt != null) {
      this.lMt.Dm(this.lMy.getText().toString());
    }
    AppMethodBeat.o(12877);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(12885);
    if ((this.lKp != null) && (this.lKp.isShowing())) {
      this.lKp.dismiss();
    }
    paramString = com.tencent.mm.broadcast.a.CH(paramString);
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
    au contact;
    int order = 0;
    int type;
    
    public a(int paramInt)
    {
      this.type = paramInt;
      this.contact = null;
    }
    
    public a(au paramau, int paramInt)
    {
      this.type = 1;
      this.contact = paramau;
      this.order = paramInt;
    }
  }
  
  final class b
    extends BaseAdapter
  {
    private List<SeeRoomMemberUI.a> hSb;
    private List<String> lMF;
    public String lMG;
    private boolean lMH;
    private String lMI;
    private List<SeeRoomMemberUI.a> lMJ;
    private com.tencent.mm.plugin.messenger.foundation.a.n lMK;
    private com.tencent.mm.storage.aj lzy;
    private Context mContext;
    private String roomId;
    
    public b(com.tencent.mm.storage.aj paramaj, String paramString1, List<String> paramList, String paramString2)
    {
      AppMethodBeat.i(12868);
      this.lMH = false;
      this.lMI = null;
      this.hSb = new ArrayList();
      this.lzy = paramString1;
      this.roomId = paramList;
      this.lMF = paramString2;
      Object localObject;
      this.lMI = localObject;
      this.mContext = paramaj;
      this.lMK = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class));
      bv(v.Il(paramList));
      AppMethodBeat.o(12868);
    }
    
    private void Dl(String paramString)
    {
      AppMethodBeat.i(12870);
      ArrayList localArrayList = new ArrayList();
      if (!Util.isNullOrNil(paramString))
      {
        Iterator localIterator = this.lMJ.iterator();
        while (localIterator.hasNext())
        {
          SeeRoomMemberUI.a locala = (SeeRoomMemberUI.a)localIterator.next();
          if ((locala != null) && (locala.contact != null) && (locala.type == 1))
          {
            Object localObject = locala.contact;
            if ((((az)localObject).field_conRemark != null) && (((az)localObject).field_conRemark.toUpperCase().contains(paramString.toUpperCase())))
            {
              localArrayList.add(locala);
            }
            else if ((!Util.isNullOrNil(SeeRoomMemberUI.a(this.lzy, ((az)localObject).field_username))) && (SeeRoomMemberUI.a(this.lzy, ((az)localObject).field_username).contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((au)localObject).aSU() != null) && (((au)localObject).aSU().toUpperCase().contains(paramString.toUpperCase())))
            {
              localArrayList.add(locala);
            }
            else if ((((au)localObject).aJt() != null) && (((au)localObject).aJt().toUpperCase().contains(paramString.toUpperCase())))
            {
              localArrayList.add(locala);
            }
            else if ((((au)localObject).aJs() != null) && (((au)localObject).aJs().contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((az)localObject).field_username != null) && (((az)localObject).field_username.contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if (!d.rs(((az)localObject).field_type))
            {
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzB().aMi(((az)localObject).field_username);
              if ((localObject != null) && (((cr)localObject).field_conRemark != null) && (((cr)localObject).field_conRemark.toUpperCase().contains(paramString.toUpperCase()))) {
                localArrayList.add(locala);
              }
            }
          }
        }
        Log.i("MicroMsg.SeeRoomMemberUI", "[setMemberListBySearch]");
      }
      for (this.hSb = localArrayList;; this.hSb = this.lMJ)
      {
        notifyDataSetChanged();
        AppMethodBeat.o(12870);
        return;
      }
    }
    
    public final void Dm(String paramString)
    {
      AppMethodBeat.i(12873);
      this.lMH = true;
      this.lMG = paramString;
      Dl(paramString);
      AppMethodBeat.o(12873);
    }
    
    public final void bv(List<String> paramList)
    {
      AppMethodBeat.i(12869);
      if (paramList == null)
      {
        AppMethodBeat.o(12869);
        return;
      }
      this.hSb.clear();
      int i = 0;
      if (i < paramList.size())
      {
        au localau = this.lMK.bzA().JE((String)paramList.get(i));
        if (this.lzy.Jf(localau.field_username)) {
          this.hSb.add(new SeeRoomMemberUI.a(localau, 3));
        }
        for (;;)
        {
          i += 1;
          break;
          if (this.lzy.bvK(localau.field_username)) {
            this.hSb.add(new SeeRoomMemberUI.a(localau, 2));
          } else {
            this.hSb.add(new SeeRoomMemberUI.a(localau, 1));
          }
        }
      }
      Collections.sort(this.hSb, new Comparator() {});
      this.hSb.add(new SeeRoomMemberUI.a(2));
      if (this.lzy.aMF()) {
        this.hSb.add(new SeeRoomMemberUI.a(3));
      }
      this.lMJ = this.hSb;
      notifyDataSetChanged();
      AppMethodBeat.o(12869);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(12874);
      int i = this.hSb.size();
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
        localView = View.inflate(this.mContext, a.f.lGx, null);
        localc = new SeeRoomMemberUI.c((byte)0);
        localc.lMM = ((AvatarPatTipImageView)localView.findViewById(a.e.see_roommember_avatar));
        localc.lDe = ((TextView)localView.findViewById(a.e.see_roommember_name));
        paramView = (WindowManager)this.mContext.getSystemService("window");
        localc.lDe.setMaxWidth(paramView.getDefaultDisplay().getWidth() * 2 / 3);
        localc.lMN = ((TextView)localView.findViewById(a.e.see_roommember_name_sub_detail));
        localView.setTag(localc);
        localc.lMM.setTag(Integer.valueOf(paramInt));
        if (localc.lMN != null) {
          localc.lMN.setVisibility(8);
        }
        paramView = (SeeRoomMemberUI.a)this.hSb.get(paramInt);
        if ((paramView == null) || (paramView.type != 1)) {
          break label472;
        }
        au localau = paramView.contact;
        com.tencent.mm.pluginsdk.ui.a.b.g(localc.lMM, localau.field_username);
        str = SeeRoomMemberUI.a(this.lzy, localau.field_username);
        if (Util.isNullOrNil(localau.field_conRemark)) {
          break label445;
        }
        paramViewGroup = localau.field_conRemark;
        label229:
        paramView = paramViewGroup;
        if (Util.isNullOrNil(paramViewGroup)) {
          paramView = localau.aSU();
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
        localc.lDe.setVisibility(0);
        localc.lDe.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this.mContext, paramViewGroup, localc.lDe.getTextSize()));
        localc.lMM.setTagUsername(localau.field_username);
        localc.lMM.setTagTalker(this.roomId);
        localc.lMM.setTagScene(4);
        localc.lMM.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(241667);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/SeeRoomMemberUI$ChatroomMemberAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            Log.i("MicroMsg.SeeRoomMemberUI", "onItemClick %s%s", new Object[] { paramAnonymousView, paramAnonymousView.getTag() });
            if (paramAnonymousView.getTag() != null)
            {
              int i = ((Integer)paramAnonymousView.getTag()).intValue();
              SeeRoomMemberUI.k(SeeRoomMemberUI.this).onItemClick(SeeRoomMemberUI.b(SeeRoomMemberUI.this), paramAnonymousView, i, SeeRoomMemberUI.b.this.getItemId(i));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SeeRoomMemberUI$ChatroomMemberAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(241667);
          }
        });
        if (localc.lMN != null)
        {
          paramView = com.tencent.mm.openim.room.a.a.X(localau);
          if (!TextUtils.isEmpty(paramView)) {
            break label451;
          }
          localc.lMN.setVisibility(8);
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
        localc.lMN.setVisibility(0);
        localc.lMN.setText(paramView);
        continue;
        label472:
        if ((paramView != null) && (paramView.type == 2))
        {
          localc.lDe.setVisibility(4);
          localc.lMM.setImageResource(a.d.big_add_selector);
          localc.lMM.setContentDescription(this.mContext.getString(com.tencent.mm.pluginsdk.a.a.e.add_selector_btn));
          localc.lMM.setTagUsername("");
        }
        else if ((paramView != null) && (paramView.type == 3))
        {
          localc.lDe.setVisibility(4);
          localc.lMM.setImageResource(a.d.big_del_selector);
          localc.lMM.setContentDescription(this.mContext.getString(com.tencent.mm.pluginsdk.a.a.e.del_selector_btn));
          localc.lMM.setTagUsername("");
        }
      }
    }
    
    public final SeeRoomMemberUI.a qE(int paramInt)
    {
      AppMethodBeat.i(12871);
      SeeRoomMemberUI.a locala = (SeeRoomMemberUI.a)this.hSb.get(paramInt);
      AppMethodBeat.o(12871);
      return locala;
    }
  }
  
  static final class c
  {
    public TextView lDe;
    public AvatarPatTipImageView lMM;
    public TextView lMN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomMemberUI
 * JD-Core Version:    0.7.0.1
 */