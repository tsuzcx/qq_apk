package com.tencent.mm.plugin.label.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.chatroom.ui.SelectMemberScrollBar;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.label.b.e;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.dgk;
import com.tencent.mm.protocal.protobuf.fve;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.mm.ui.contact.a.j;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.am;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/label/ui/ContactEditLabel;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/ui/contact/IBaseSelectContactUI;", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "INTENT_STATUS_MGR", "", "MSG_TRIGGER_SYNC", "", "getMSG_TRIGGER_SYNC", "()I", "MSG_UPDATE_CONTACT_LIST", "getMSG_UPDATE_CONTACT_LIST", "REQUEST_CODE_SELECT_CONTACT", "getREQUEST_CODE_SELECT_CONTACT", "TAG", "adapter", "Lcom/tencent/mm/plugin/label/ui/ContactEditLabel$OnlyChatContactAdapter;", "emptyView", "Landroid/widget/TextView;", "isFromAddress", "", "isFromSelectChatroom", "listView", "Landroid/widget/ListView;", "mAddContactList", "Ljava/util/HashSet;", "mAddContactListFromChatroom", "mCurName", "mCureentContactList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mDelContactList", "mHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mIsFirstIn", "mIsNewLabel", "mIsShowDelete", "mLableId", "mLoadingDialog", "Landroid/app/ProgressDialog;", "mMMTitle", "mOriginalContactList", "mOrignalName", "mSelectedLabel", "Lcom/tencent/mm/storage/ContactLabel;", "mSource", "mUserNameSelf", "searchET", "Landroid/widget/EditText;", "selectMemberScrollBar", "Lcom/tencent/mm/chatroom/ui/SelectMemberScrollBar;", "x_down", "y_down", "addNewMembersToLabel", "", "dealRemoveContact", "userName", "doAddLabelScene", "labelName", "doDeleteFailed", "doDeleteLocalDB", "doDeleteSuccess", "doInsertOrUpdateLable", "id", "name", "isNewLabel", "doUpateLabelScene", "labelId", "doUpdateContactList", "formatNames", "getActivity", "Landroid/app/Activity;", "getContentLV", "getDesc", "item", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "getLayoutId", "getSelectContactNames", "hideLoading", "initMemberList", "isExistLabel", "isItemAlwaysCheck", "isItemCheck", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNotifyChange", "event", "stg", "Lcom/tencent/mm/sdk/storage/MStorageEx;", "obj", "", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "savaSuccess", "saveFailed", "saveLabelChange", "showErrorDialog", "msg", "showLoading", "showSaveTipDialog", "updateContactLabelPref", "updateTitle", "text", "bindUIAndSetListener", "OnlyChatContactAdapter", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ContactEditLabel
  extends MMActivity
  implements com.tencent.mm.am.h, MStorageEx.IOnStorageChange, o
{
  private EditText Cxu;
  private boolean JLD;
  private ArrayList<String> JUA;
  private ArrayList<String> JUB;
  private final HashSet<String> JUC;
  private final HashSet<String> JUD;
  private final HashSet<String> JUE;
  private String JUF;
  private String JUG;
  private boolean JUH;
  private final String JUI;
  private a JUJ;
  private final int JUo;
  final int JUp;
  private final int JUq;
  private String JUr;
  private String JUs;
  private String JUt;
  private aw JUu;
  private boolean JUv;
  private boolean JUw;
  private String JUx;
  private boolean JUy;
  private SelectMemberScrollBar JUz;
  private final String TAG;
  private final MMHandler mHandler;
  private TextView njO;
  private ProgressDialog pNH;
  private ListView qgc;
  private int x_down;
  private int y_down;
  
  public ContactEditLabel()
  {
    AppMethodBeat.i(268952);
    this.TAG = "MicroMsg.Label.ContactEditLabel";
    this.JUo = 7001;
    this.JUp = 6001;
    this.JUq = 6002;
    this.JUy = true;
    this.JUA = new ArrayList();
    this.JUB = new ArrayList();
    this.JUC = new HashSet();
    this.JUD = new HashSet();
    this.JUE = new HashSet();
    this.JLD = true;
    this.JUI = "intent_status_mgr";
    this.mHandler = ((MMHandler)new j(this, Looper.getMainLooper()));
    AppMethodBeat.o(268952);
  }
  
  private static final void F(DialogInterface paramDialogInterface, int paramInt) {}
  
  private static final void a(ContactEditLabel paramContactEditLabel, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(269007);
    kotlin.g.b.s.u(paramContactEditLabel, "this$0");
    paramContactEditLabel.fTi();
    AppMethodBeat.o(269007);
  }
  
  private static final void a(ContactEditLabel paramContactEditLabel, View paramView)
  {
    AppMethodBeat.i(268999);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramContactEditLabel);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/label/ui/ContactEditLabel", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramContactEditLabel, "$this_bindUIAndSetListener");
    paramView = paramContactEditLabel.qgc;
    paramContactEditLabel = paramView;
    if (paramView == null)
    {
      kotlin.g.b.s.bIx("listView");
      paramContactEditLabel = null;
    }
    paramContactEditLabel = new com.tencent.mm.hellhoundlib.b.a().cG(paramContactEditLabel);
    paramView = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(paramView, paramContactEditLabel.aYi(), "com/tencent/mm/plugin/label/ui/ContactEditLabel", "bindUIAndSetListener$lambda-0", "(Lcom/tencent/mm/plugin/label/ui/ContactEditLabel;Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramContactEditLabel.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/label/ui/ContactEditLabel", "bindUIAndSetListener$lambda-0", "(Lcom/tencent/mm/plugin/label/ui/ContactEditLabel;Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/label/ui/ContactEditLabel", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(268999);
  }
  
  private static boolean aJL(String paramString)
  {
    AppMethodBeat.i(268993);
    if (!Util.isNullOrNil(com.tencent.mm.plugin.label.d.fTa().aJH(paramString)))
    {
      AppMethodBeat.o(268993);
      return true;
    }
    AppMethodBeat.o(268993);
    return false;
  }
  
  private void aoP(String paramString)
  {
    AppMethodBeat.i(268963);
    k.d((Context)this, paramString, "", ContactEditLabel..ExternalSyntheticLambda3.INSTANCE);
    AppMethodBeat.o(268963);
  }
  
  private static final void b(ContactEditLabel paramContactEditLabel, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(269010);
    kotlin.g.b.s.u(paramContactEditLabel, "this$0");
    paramContactEditLabel.setResult(0);
    paramContactEditLabel.finish();
    AppMethodBeat.o(269010);
  }
  
  private final void fTe()
  {
    AppMethodBeat.i(268956);
    aoP(getString(R.l.gEb));
    AppMethodBeat.o(268956);
  }
  
  private final void fTf()
  {
    AppMethodBeat.i(268970);
    Log.i(this.TAG, "cpan[savaSuccess]");
    hideLoading();
    if (this.JUC != null) {}
    for (int i = this.JUC.size();; i = 0)
    {
      if (this.JUE != null) {}
      for (int j = this.JUE.size();; j = 0)
      {
        Log.i(this.TAG, "cpan[doUpdateContactList]addnum:%d", new Object[] { Integer.valueOf(i) });
        Object localObject;
        int k;
        if (i > 0)
        {
          int m = this.JUD.size();
          int n = Math.max(0, i - m);
          localObject = com.tencent.mm.plugin.report.service.h.OAn;
          String str = z.bAM();
          if (this.JUv)
          {
            k = 1;
            ((com.tencent.mm.plugin.report.service.h)localObject).b(11220, new Object[] { str, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) });
          }
        }
        else
        {
          if (!this.JUy) {
            break label326;
          }
          localObject = getIntent();
          ((Intent)localObject).putExtra("k_sns_label_add_label", this.JUs);
          ((Intent)localObject).putStringArrayListExtra("k_sns_label_add_label_usernames", new ArrayList((Collection)this.JUC));
          setResult(0, (Intent)localObject);
          if (!this.JUH) {
            break label289;
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2) });
        }
        for (;;)
        {
          finish();
          AppMethodBeat.o(268970);
          return;
          k = 2;
          break;
          label289:
          com.tencent.mm.plugin.report.service.h.OAn.b(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(3) });
        }
        label326:
        if (i > 0)
        {
          if (this.JUH) {
            com.tencent.mm.plugin.report.service.h.OAn.b(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(2) });
          }
        }
        else {
          label371:
          if (j > 0)
          {
            if (!this.JUH) {
              break label461;
            }
            com.tencent.mm.plugin.report.service.h.OAn.b(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(2) });
          }
        }
        for (;;)
        {
          setResult(0);
          break;
          com.tencent.mm.plugin.report.service.h.OAn.b(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(3) });
          break label371;
          label461:
          com.tencent.mm.plugin.report.service.h.OAn.b(16097, new Object[] { Integer.valueOf(1), Integer.valueOf(4), Integer.valueOf(3) });
        }
      }
    }
  }
  
  private final void fTg()
  {
    AppMethodBeat.i(268979);
    Log.i(this.TAG, "cpan[saveFailed]");
    hideLoading();
    aoP(getString(R.l.gpI));
    AppMethodBeat.o(268979);
  }
  
  private final void fTh()
  {
    AppMethodBeat.i(268986);
    Object localObject1 = this.TAG;
    Object localObject2 = this.JUC;
    int i;
    int j;
    if (localObject2 == null)
    {
      i = 0;
      localObject2 = this.JUE;
      if (localObject2 != null) {
        break label164;
      }
      j = 0;
      label37:
      Log.i((String)localObject1, "cpan[doUpdateContactList] addcount:%d,delcount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      localObject1 = new LinkedList();
      if ((this.JUC == null) || (this.JUC.size() <= 0)) {
        break label285;
      }
      this.JUC.size();
      localObject2 = this.JUC.iterator();
      kotlin.g.b.s.s(localObject2, "mAddContactList.iterator()");
    }
    Object localObject3;
    label164:
    Object localObject4;
    String str;
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label285;
      }
      localObject3 = ((Iterator)localObject2).next();
      if (localObject3 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(268986);
        throw ((Throwable)localObject1);
        i = ((HashSet)localObject2).size();
        break;
        j = ((HashSet)localObject2).size();
        break label37;
      }
      localObject3 = (String)localObject3;
      bh.bCz();
      localObject3 = com.tencent.mm.model.c.bzA().JE((String)localObject3);
      localObject4 = ((com.tencent.mm.autogen.b.az)localObject3).field_contactLabelIds;
      str = com.tencent.mm.plugin.label.c.jQ((String)localObject4, this.JUt);
      Log.i(this.TAG, "labels:%s mixLabelIds:%s", new Object[] { localObject4, str });
      if (!kotlin.n.n.T(str, (String)localObject4, true))
      {
        localObject4 = new fve();
        ((fve)localObject4).UserName = ((com.tencent.mm.autogen.b.az)localObject3).field_username;
        ((fve)localObject4).ZqN = str;
        ((LinkedList)localObject1).add(localObject4);
      }
    }
    label285:
    if ((this.JUE != null) && (this.JUE.size() > 0))
    {
      this.JUE.size();
      localObject2 = this.JUE.iterator();
      kotlin.g.b.s.s(localObject2, "mDelContactList.iterator()");
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (localObject3 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(268986);
          throw ((Throwable)localObject1);
        }
        localObject3 = (String)localObject3;
        bh.bCz();
        localObject4 = com.tencent.mm.model.c.bzA().JE((String)localObject3).field_contactLabelIds;
        str = com.tencent.mm.plugin.label.c.jR((String)localObject4, this.JUt);
        Log.i(this.TAG, "username:%s labels:%s mixLabelIds:%s", new Object[] { localObject3, localObject4, str });
        if (!kotlin.n.n.T(str, (String)localObject4, true))
        {
          localObject4 = new fve();
          ((fve)localObject4).UserName = ((String)localObject3);
          ((fve)localObject4).ZqN = str;
          ((LinkedList)localObject1).add(localObject4);
        }
      }
    }
    if (((LinkedList)localObject1).size() > 0)
    {
      localObject1 = new e((LinkedList)localObject1);
      bh.aZW().a((p)localObject1, 0);
      AppMethodBeat.o(268986);
      return;
    }
    fTf();
    AppMethodBeat.o(268986);
  }
  
  private final void fTi()
  {
    AppMethodBeat.i(268991);
    Log.i(this.TAG, "cpan[saveLabelChange]");
    Object localObject = getString(R.l.gMu);
    kotlin.g.b.s.s(localObject, "getString(R.string.label_saving)");
    Context localContext = (Context)this;
    getString(R.l.app_tip);
    this.pNH = ((ProgressDialog)k.a(localContext, (String)localObject, true, ContactEditLabel..ExternalSyntheticLambda0.INSTANCE));
    this.JUs = Util.nullAs(this.JUs, "");
    localObject = this.JUs;
    kotlin.g.b.s.checkNotNull(localObject);
    localObject = (CharSequence)localObject;
    int i = ((CharSequence)localObject).length() - 1;
    int k = 0;
    int j = 0;
    while (j <= i)
    {
      int m;
      if (k == 0)
      {
        m = j;
        label123:
        if (kotlin.g.b.s.compare(((CharSequence)localObject).charAt(m), 32) > 0) {
          break label163;
        }
        m = 1;
      }
      for (;;)
      {
        if (k == 0)
        {
          if (m == 0)
          {
            k = 1;
            break;
            m = i;
            break label123;
            label163:
            m = 0;
            continue;
          }
          j += 1;
          break;
        }
      }
      if (m == 0) {
        break;
      }
      i -= 1;
    }
    this.JUs = ((CharSequence)localObject).subSequence(j, i + 1).toString();
    if (Util.isNullOrNil(this.JUs))
    {
      hideLoading();
      aoP(getString(R.l.gMn));
      AppMethodBeat.o(268991);
      return;
    }
    if (g.bCx(this.JUs) > 36)
    {
      hideLoading();
      localObject = am.aixg;
      localObject = getString(R.l.gpK);
      kotlin.g.b.s.s(localObject, "getString(R.string.add_label_over_count)");
      localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Integer.valueOf(g.ej(36, "")) }, 1));
      kotlin.g.b.s.s(localObject, "java.lang.String.format(format, *args)");
      aoP((String)localObject);
      AppMethodBeat.o(268991);
      return;
    }
    localObject = this.JUs;
    kotlin.g.b.s.checkNotNull(localObject);
    if ((!aJL((String)localObject)) || (!this.JUy))
    {
      localObject = this.JUs;
      kotlin.g.b.s.checkNotNull(localObject);
      if ((!aJL((String)localObject)) || (Util.isNullOrNil(this.JUr)) || (kotlin.g.b.s.p(this.JUr, this.JUs))) {}
    }
    else
    {
      hideLoading();
      aoP(getString(R.l.gpH));
      AppMethodBeat.o(268991);
      return;
    }
    localObject = com.tencent.mm.plugin.label.d.fTa().bxn(this.JUt);
    if ((this.JUy) || (((aw)localObject).field_isTemporary))
    {
      localObject = this.JUs;
      kotlin.g.b.s.checkNotNull(localObject);
      localObject = new com.tencent.mm.plugin.label.b.a((String)localObject);
      bh.aZW().a((p)localObject, 0);
      AppMethodBeat.o(268991);
      return;
    }
    i = Util.getInt(this.JUt, 0);
    localObject = this.JUs;
    kotlin.g.b.s.checkNotNull(localObject);
    localObject = new com.tencent.mm.plugin.label.b.f(i, (String)localObject);
    bh.aZW().a((p)localObject, 0);
    AppMethodBeat.o(268991);
  }
  
  private final void hideLoading()
  {
    AppMethodBeat.i(268975);
    if (this.pNH != null)
    {
      ProgressDialog localProgressDialog = this.pNH;
      kotlin.g.b.s.checkNotNull(localProgressDialog);
      if (localProgressDialog.isShowing())
      {
        localProgressDialog = this.pNH;
        kotlin.g.b.s.checkNotNull(localProgressDialog);
        localProgressDialog.dismiss();
      }
    }
    AppMethodBeat.o(268975);
  }
  
  private static final void z(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(269013);
    bh.aZW().cancel(635);
    bh.aZW().cancel(637);
    AppMethodBeat.o(269013);
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(269075);
    if ((parama instanceof com.tencent.mm.ui.contact.a.f))
    {
      a locala2 = this.JUJ;
      a locala1 = locala2;
      if (locala2 == null)
      {
        kotlin.g.b.s.bIx("adapter");
        locala1 = null;
      }
      boolean bool = locala1.JUM.contains(((com.tencent.mm.ui.contact.a.f)parama).username);
      AppMethodBeat.o(269075);
      return bool;
    }
    AppMethodBeat.o(269075);
    return false;
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    return false;
  }
  
  public final String c(com.tencent.mm.ui.contact.a.a parama)
  {
    return null;
  }
  
  public final Activity getActivity()
  {
    return (Activity)this;
  }
  
  public final ListView getContentLV()
  {
    AppMethodBeat.i(269078);
    ListView localListView = this.qgc;
    if (localListView == null)
    {
      kotlin.g.b.s.bIx("listView");
      AppMethodBeat.o(269078);
      return null;
    }
    AppMethodBeat.o(269078);
    return localListView;
  }
  
  public final int getLayoutId()
  {
    return R.i.gmK;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(269084);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i(this.TAG, "cpan[onActivityResult] requestCode:%d resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(269084);
      return;
    }
    if (paramInt1 == this.JUo)
    {
      kotlin.g.b.s.checkNotNull(paramIntent);
      String str = paramIntent.getStringExtra("Select_Contact");
      boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
      Log.i(this.TAG, "cpan[onActivityResult] %s", new Object[] { kotlin.g.b.s.X(str, "") });
      if (!Util.isNullOrNil(str))
      {
        kotlin.g.b.s.checkNotNull(str);
        paramIntent = ((Collection)kotlin.n.n.a((CharSequence)str, new String[] { "," })).toArray(new String[0]);
        if (paramIntent == null)
        {
          paramIntent = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
          AppMethodBeat.o(269084);
          throw paramIntent;
        }
        paramIntent = (List)Util.stringsToList((String[])paramIntent);
        if ((paramIntent != null) && (paramIntent.size() > 0))
        {
          paramInt2 = paramIntent.size();
          paramInt1 = 0;
          if (paramInt1 < paramInt2)
          {
            str = (String)paramIntent.get(paramInt1);
            if (!Util.isNullOrNil(str))
            {
              if ((!ab.IR(str)) || (this.JUA.contains(str)) || (kotlin.g.b.s.p(str, this.JUF))) {
                break label361;
              }
              this.JUA.add(str);
              if ((this.JUB != null) && (!this.JUB.contains(paramIntent.get(paramInt1)))) {
                this.JUC.add(str);
              }
              if (bool) {
                this.JUD.add(str);
              }
              if ((this.JUE != null) && (this.JUE.contains(str))) {
                this.JUE.remove(str);
              }
            }
            for (;;)
            {
              paramInt1 += 1;
              break;
              label361:
              Log.i(this.TAG, "dz[getIntent] %s is no friend or is user self and just filter", new Object[] { str });
            }
          }
          if (!Util.isNullOrNil(this.JUs)) {
            enableOptionMenu(true);
          }
        }
        if (this.mHandler != null) {
          this.mHandler.sendEmptyMessage(6001);
        }
      }
    }
    AppMethodBeat.o(269084);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(269087);
    if (((!Util.isNullOrNil(this.JUs)) && (!kotlin.g.b.s.p(this.JUs, this.JUr))) || ((this.JUC != null) && (this.JUC.size() > 0)) || ((this.JUE != null) && (this.JUE.size() > 0)))
    {
      k.b((Context)this, getString(R.l.save_label_msg), "", getString(R.l.gvW), getString(R.l.gvX), new ContactEditLabel..ExternalSyntheticLambda1(this), new ContactEditLabel..ExternalSyntheticLambda2(this));
      AppMethodBeat.o(269087);
      return;
    }
    setResult(0);
    finish();
    AppMethodBeat.o(269087);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(269066);
    super.onCreate(paramBundle);
    this.JUF = z.bAM();
    this.JUt = getIntent().getStringExtra("label_id");
    this.JUr = getIntent().getStringExtra("label_name");
    if ((this.JUr == null) || (kotlin.g.b.s.p(this.JUr, ""))) {
      this.JUr = " ";
    }
    this.JUs = getIntent().getStringExtra("label_name");
    if ((this.JUs == null) || (kotlin.g.b.s.p(this.JUs, ""))) {
      this.JUs = " ";
    }
    this.JUv = getIntent().getBooleanExtra("Is_Chatroom", false);
    this.JUG = getIntent().getStringExtra("label_source");
    if ((this.JUG != null) && (kotlin.n.n.T(this.JUG, "label_source_Address", false))) {}
    for (boolean bool = true;; bool = false)
    {
      this.JUH = bool;
      this.JUw = getIntent().getBooleanExtra("is_show_delete", true);
      paramBundle = getIntent().getStringExtra("Select_Contact");
      if (Util.isNullOrNil(paramBundle)) {
        break label418;
      }
      kotlin.g.b.s.checkNotNull(paramBundle);
      paramBundle = ((Collection)kotlin.n.n.a((CharSequence)paramBundle, new String[] { "," })).toArray(new String[0]);
      if (paramBundle != null) {
        break;
      }
      paramBundle = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(269066);
      throw paramBundle;
    }
    paramBundle = (List)Util.stringsToList((String[])paramBundle);
    this.JUA = new ArrayList();
    int k;
    if ((paramBundle != null) && (paramBundle.size() > 0))
    {
      k = paramBundle.size();
      if (k <= 0) {}
    }
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      Object localObject = (String)paramBundle.get(i);
      if (!Util.isNullOrNil((String)localObject))
      {
        if ((!ab.IR((String)localObject)) || (this.JUA.contains(localObject)) || (kotlin.g.b.s.p(localObject, this.JUF))) {
          break label1005;
        }
        this.JUA.add(localObject);
        this.JUC.add(localObject);
        if (this.JUv) {
          this.JUD.add(localObject);
        }
      }
      if (j >= k)
      {
        label418:
        bh.aZW().a(635, (com.tencent.mm.am.h)this);
        bh.aZW().a(637, (com.tencent.mm.am.h)this);
        bh.aZW().a(638, (com.tencent.mm.am.h)this);
        bh.baH().postToWorker((Runnable)new i(this));
        if (Util.isNullOrNil(this.JUt))
        {
          this.JUy = true;
          this.JUx = getString(R.l.gRA);
          label501:
          setMMTitle(this.JUx);
          paramBundle = findViewById(R.h.fOe);
          kotlin.g.b.s.s(paramBundle, "findViewById(R.id.member_list)");
          this.qgc = ((ListView)paramBundle);
          setToTop(new ContactEditLabel..ExternalSyntheticLambda4(this));
          paramBundle = findViewById(R.h.empty_tip_tv);
          kotlin.g.b.s.s(paramBundle, "findViewById(R.id.empty_tip_tv)");
          this.njO = ((TextView)paramBundle);
          localObject = this.njO;
          paramBundle = (Bundle)localObject;
          if (localObject == null)
          {
            kotlin.g.b.s.bIx("emptyView");
            paramBundle = null;
          }
          paramBundle.setVisibility(8);
          this.JUJ = new a((o)this);
          if (getIntent().getBooleanExtra(this.JUI, false))
          {
            localObject = this.JUJ;
            paramBundle = (Bundle)localObject;
            if (localObject == null)
            {
              kotlin.g.b.s.bIx("adapter");
              paramBundle = null;
            }
            paramBundle.afey = true;
          }
          paramBundle = findViewById(R.h.fOg);
          kotlin.g.b.s.s(paramBundle, "findViewById(R.id.mgr_footer)");
          ((LinearLayout)paramBundle).setVisibility(8);
          paramBundle = this.qgc;
          if (paramBundle != null) {
            break label1060;
          }
          kotlin.g.b.s.bIx("listView");
          paramBundle = null;
          label694:
          paramBundle.setOnItemClickListener((AdapterView.OnItemClickListener)new b(this));
          paramBundle = this.qgc;
          if (paramBundle != null) {
            break label1063;
          }
          kotlin.g.b.s.bIx("listView");
          paramBundle = null;
          label726:
          paramBundle.setOnItemLongClickListener((AdapterView.OnItemLongClickListener)new c(this));
          paramBundle = this.qgc;
          if (paramBundle != null) {
            break label1066;
          }
          kotlin.g.b.s.bIx("listView");
          paramBundle = null;
          label758:
          paramBundle.setOnTouchListener((View.OnTouchListener)new d(this));
          paramBundle = this.qgc;
          if (paramBundle != null) {
            break label1069;
          }
          kotlin.g.b.s.bIx("listView");
          paramBundle = null;
          label790:
          a locala = this.JUJ;
          localObject = locala;
          if (locala == null)
          {
            kotlin.g.b.s.bIx("adapter");
            localObject = null;
          }
          paramBundle.setAdapter((ListAdapter)localObject);
          paramBundle = findViewById(R.h.fOf);
          kotlin.g.b.s.s(paramBundle, "findViewById(R.id.member_scrollbar)");
          this.JUz = ((SelectMemberScrollBar)paramBundle);
          paramBundle = this.JUz;
          if (paramBundle != null) {
            break label1072;
          }
          kotlin.g.b.s.bIx("selectMemberScrollBar");
          paramBundle = null;
          label863:
          paramBundle.setOnScrollBarTouchListener((VerticalScrollBar.a)new e(this));
          paramBundle = findViewById(R.h.fVL);
          kotlin.g.b.s.s(paramBundle, "findViewById<MMEditText>(R.id.select_member_et)");
          this.Cxu = ((EditText)paramBundle);
          paramBundle = this.Cxu;
          if (paramBundle != null) {
            break label1075;
          }
          kotlin.g.b.s.bIx("searchET");
          paramBundle = null;
        }
        label1060:
        label1063:
        label1066:
        label1069:
        label1072:
        label1075:
        for (;;)
        {
          paramBundle.addTextChangedListener((TextWatcher)new f(this));
          setBackBtn((MenuItem.OnMenuItemClickListener)new g(this));
          addTextOptionMenu(0, getString(R.l.gDz), (MenuItem.OnMenuItemClickListener)new h(this), null, y.b.adEJ);
          ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().add((MStorageEx.IOnStorageChange)this);
          AppMethodBeat.o(269066);
          return;
          label1005:
          Log.i(this.TAG, "dz[getIntent] %s is no friend or is user self and just filter", new Object[] { localObject });
          break;
          this.JUy = false;
          this.JUu = com.tencent.mm.plugin.label.d.fTa().bxn(this.JUt);
          this.JUx = getString(R.l.gRz);
          break label501;
          break label694;
          break label726;
          break label758;
          break label790;
          break label863;
        }
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(269067);
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().remove((MStorageEx.IOnStorageChange)this);
    bh.aZW().b(635, (com.tencent.mm.am.h)this);
    bh.aZW().b(637, (com.tencent.mm.am.h)this);
    bh.aZW().b(638, (com.tencent.mm.am.h)this);
    a locala2 = this.JUJ;
    a locala1 = locala2;
    if (locala2 == null)
    {
      kotlin.g.b.s.bIx("adapter");
      locala1 = null;
    }
    locala1.finish();
    this.mHandler.removeCallbacksAndMessages(null);
    super.onDestroy();
    AppMethodBeat.o(269067);
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(269081);
    paramObject = this.JUJ;
    paramMStorageEx = paramObject;
    if (paramObject == null)
    {
      kotlin.g.b.s.bIx("adapter");
      paramMStorageEx = null;
    }
    paramMStorageEx.aNm();
    AppMethodBeat.o(269081);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(269068);
    com.tencent.mm.modelstat.d.d(4, kotlin.g.b.s.X("ContactEditLabel", getIdentString()), hashCode());
    bh.aZW().b(636, (com.tencent.mm.am.h)this);
    super.onPause();
    AppMethodBeat.o(269068);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(269071);
    com.tencent.mm.modelstat.d.d(3, kotlin.g.b.s.X("ContactLabelEditUI", getIdentString()), hashCode());
    bh.aZW().a(636, (com.tencent.mm.am.h)this);
    super.onResume();
    AppMethodBeat.o(269071);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(269069);
    Log.i(this.TAG, "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    kotlin.g.b.s.checkNotNull(paramp);
    switch (paramp.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(269069);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.label.b.a)paramp).fTc();
        kotlin.g.b.s.s(paramString, "addContact.response");
        paramString = paramString.YFs;
        kotlin.g.b.s.s(paramString, "respone.LabelPairList");
        if (paramString.size() > 0)
        {
          paramString = paramString.get(0);
          kotlin.g.b.s.s(paramString, "list[0]");
          paramString = (dgk)paramString;
          Log.i(this.TAG, "cpan[onSceneEnd] add label pair.LabelID:%s pair.LabelName:%s", new Object[] { paramString.aaLB, paramString.aaLA });
          this.JUt = paramString.aaLB;
          fTh();
          AppMethodBeat.o(269069);
          return;
        }
        fTg();
        AppMethodBeat.o(269069);
        return;
      }
      fTg();
      AppMethodBeat.o(269069);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = this.JUt;
        String str = this.JUs;
        Log.i(this.TAG, "cpan[doInsertOrUpdateLable]");
        try
        {
          kotlin.g.b.s.checkNotNull(paramString);
          paramp = Integer.valueOf(paramString);
          kotlin.g.b.s.s(paramp, "valueOf(id!!)");
          paramInt1 = ((Number)paramp).intValue();
          if (paramInt1 != -1)
          {
            paramp = com.tencent.mm.plugin.label.d.fTa().bxn(paramString);
            paramString = paramp;
            if (paramp == null) {
              paramString = new aw();
            }
            paramString.field_labelID = paramInt1;
            paramString.field_labelName = str;
            paramString.field_labelPYFull = com.tencent.mm.platformtools.f.RZ(str);
            paramString.field_labelPYShort = com.tencent.mm.platformtools.f.Sa(str);
            com.tencent.mm.plugin.label.d.fTa().b(paramString, new String[] { "labelID" });
            fTh();
            AppMethodBeat.o(269069);
            return;
          }
        }
        catch (Exception paramp)
        {
          for (;;)
          {
            Log.e(this.TAG, "id is not integer type:%s", new Object[] { kotlin.g.b.s.X(paramString, "") });
            paramInt1 = -1;
            continue;
            fTg();
          }
        }
      }
      fTg();
      AppMethodBeat.o(269069);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        fTf();
        if (this.mHandler != null)
        {
          this.mHandler.sendEmptyMessageDelayed(6002, 300L);
          AppMethodBeat.o(269069);
        }
      }
      else
      {
        fTg();
        AppMethodBeat.o(269069);
        return;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = this.JUu;
          paramp = com.tencent.mm.plugin.label.d.fTa();
          kotlin.g.b.s.checkNotNull(paramString);
          if (!paramp.a(paramString, new String[] { "labelID" }))
          {
            Log.w(this.TAG, "cpan[doDeleteContactLabel] fail.");
            fTe();
          }
          while (this.mHandler != null)
          {
            this.mHandler.sendEmptyMessageDelayed(6002, 300L);
            AppMethodBeat.o(269069);
            return;
            setResult(-1);
            finish();
          }
        }
        else
        {
          Log.w(this.TAG, "cpan[onSceneEnd] delete fail.");
          fTe();
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/label/ui/ContactEditLabel$OnlyChatContactAdapter;", "Lcom/tencent/mm/ui/contact/MMInitContactAdapter;", "activity", "Lcom/tencent/mm/ui/contact/IBaseSelectContactUI;", "(Lcom/tencent/mm/plugin/label/ui/ContactEditLabel;Lcom/tencent/mm/ui/contact/IBaseSelectContactUI;)V", "dataCursor", "Landroid/database/Cursor;", "headerPosMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "posHeaderMap", "Landroid/util/SparseArray;", "query", "selectedContacts", "Ljava/util/LinkedList;", "getSelectedContacts", "()Ljava/util/LinkedList;", "createContactItem", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "position", "createDataItem", "createHeaderAddItem", "createHeaderItem", "header", "createHeaderLabelItem", "positon", "labelName", "doSearch", "", "doSelect", "username", "finish", "getContactCount", "getCount", "getHeaderPosition", "getPosForSection", "head", "resetData", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends r
  {
    final HashMap<String, Integer> JUK;
    private final SparseArray<String> JUL;
    final LinkedList<String> JUM;
    private Cursor pKb;
    private String query;
    
    public a()
    {
      super(null, true, false);
      AppMethodBeat.i(268649);
      this.JUK = new HashMap();
      this.JUL = new SparseArray();
      this.query = "";
      this.JUM = new LinkedList();
      aNm();
      AppMethodBeat.o(268649);
    }
    
    private final com.tencent.mm.ui.contact.a.a Zx(int paramInt)
    {
      AppMethodBeat.i(268655);
      int j = 4;
      int i = paramInt;
      int k;
      int m;
      do
      {
        k = j;
        if (this.JUL.indexOfKey(i) >= 0) {
          k = j + 1;
        }
        m = i - 1;
        i = m;
        j = k;
      } while (m >= 0);
      i = paramInt - k;
      Object localObject = this.pKb;
      kotlin.g.b.s.checkNotNull(localObject);
      if (((Cursor)localObject).moveToPosition(i))
      {
        localObject = new au();
        ((au)localObject).convertFrom(this.pKb);
        com.tencent.mm.ui.contact.a.f localf = new com.tencent.mm.ui.contact.a.f(paramInt);
        localf.contact = ((au)localObject);
        if (au.bwE(((com.tencent.mm.autogen.b.az)localObject).field_username))
        {
          localf.afey = false;
          localf.afez = false;
          localf.afjA = false;
        }
        for (localf.afjT = true;; localf.afjT = false)
        {
          localObject = (com.tencent.mm.ui.contact.a.a)localf;
          AppMethodBeat.o(268655);
          return localObject;
          localf.afey = gZe();
          localf.afez = jyD();
        }
      }
      Log.i(ContactEditLabel.h(ContactEditLabel.this), "create contact item error: position=%d | index=%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(268655);
      return null;
    }
    
    private static com.tencent.mm.ui.contact.a.a cf(int paramInt, String paramString)
    {
      AppMethodBeat.i(268659);
      j localj = new j(paramInt);
      localj.header = paramString;
      paramString = (com.tencent.mm.ui.contact.a.a)localj;
      AppMethodBeat.o(268659);
      return paramString;
    }
    
    public final void aEJ(String paramString)
    {
      AppMethodBeat.i(268661);
      kotlin.g.b.s.u(paramString, "query");
      if (!kotlin.n.n.T(this.query, paramString, true)) {
        this.query = paramString;
      }
      aNm();
      Log.i(ContactEditLabel.h(ContactEditLabel.this), kotlin.g.b.s.X("query ", paramString));
      AppMethodBeat.o(268661);
    }
    
    public final int aJM(String paramString)
    {
      AppMethodBeat.i(268677);
      Map localMap = (Map)this.JUK;
      if (localMap == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        AppMethodBeat.o(268677);
        throw paramString;
      }
      if (localMap.containsKey(paramString))
      {
        paramString = ((Map)this.JUK).get(paramString);
        kotlin.g.b.s.checkNotNull(paramString);
        int i = ((Number)paramString).intValue();
        int j = this.afex.getContentLV().getHeaderViewsCount();
        AppMethodBeat.o(268677);
        return i + j;
      }
      AppMethodBeat.o(268677);
      return -1;
    }
    
    public final void aNm()
    {
      AppMethodBeat.i(268672);
      super.aNm();
      Log.i(ContactEditLabel.h(ContactEditLabel.this), "resetData");
      Object localObject1;
      if (this.pKb != null)
      {
        localObject1 = this.pKb;
        kotlin.g.b.s.checkNotNull(localObject1);
        ((Cursor)localObject1).close();
        this.pKb = null;
      }
      this.JUK.clear();
      this.JUL.clear();
      Object localObject2 = (String[])new String[0];
      this.pKb = null;
      int n;
      int k;
      if ((ContactEditLabel.k(ContactEditLabel.this) != null) && (ContactEditLabel.k(ContactEditLabel.this).size() != 0))
      {
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA();
        localObject2 = ((Collection)ContactEditLabel.k(ContactEditLabel.this)).toArray(new String[0]);
        if (localObject2 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
          AppMethodBeat.o(268672);
          throw ((Throwable)localObject1);
        }
        this.pKb = ((bx)localObject1).d((String[])localObject2, this.query, "@all.contact.android", "", null);
        localObject1 = ((Collection)ContactEditLabel.k(ContactEditLabel.this)).toArray(new String[0]);
        if (localObject1 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
          AppMethodBeat.o(268672);
          throw ((Throwable)localObject1);
        }
        localObject2 = ab.a((String[])localObject1, "@all.contact.android", "", this.query, null);
        localObject1 = ((Collection)ContactEditLabel.k(ContactEditLabel.this)).toArray(new String[0]);
        if (localObject1 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
          AppMethodBeat.o(268672);
          throw ((Throwable)localObject1);
        }
        localObject1 = ab.a((String[])localObject1, "@all.contact.android", "", null, this.query);
        if ((localObject2 != null) && (localObject1 != null))
        {
          n = localObject2.length - 1;
          if (n >= 0) {
            k = 0;
          }
        }
      }
      int j;
      for (int i = 4;; i = j)
      {
        int m = k + 1;
        j = i;
        if (k < localObject1.length)
        {
          this.JUK.put(localObject2[k], Integer.valueOf(localObject1[k] + i));
          this.JUL.put(localObject1[k] + i, localObject2[k]);
          j = i + 1;
        }
        if (m > n)
        {
          clearCache();
          notifyDataSetChanged();
          AppMethodBeat.o(268672);
          return;
          Log.i(ContactEditLabel.h(ContactEditLabel.this), "mCurrentList is null | mCurrenList size == 0");
          localObject1 = new int[0];
          break;
        }
        k = m;
      }
    }
    
    public final void finish()
    {
      AppMethodBeat.i(268685);
      super.finish();
      if (this.pKb != null)
      {
        Cursor localCursor = this.pKb;
        kotlin.g.b.s.checkNotNull(localCursor);
        localCursor.close();
        this.pKb = null;
      }
      AppMethodBeat.o(268685);
    }
    
    public final int getCount()
    {
      int j = 0;
      AppMethodBeat.i(268681);
      int i;
      if (this.pKb == null)
      {
        i = 0;
        if (this.JUL != null) {
          break label55;
        }
      }
      for (;;)
      {
        AppMethodBeat.o(268681);
        return i + j + 4;
        Cursor localCursor = this.pKb;
        kotlin.g.b.s.checkNotNull(localCursor);
        i = localCursor.getCount();
        break;
        label55:
        j = this.JUL.size();
      }
    }
    
    public final com.tencent.mm.ui.contact.a.a yk(int paramInt)
    {
      AppMethodBeat.i(268693);
      Object localObject1;
      if (paramInt == 0)
      {
        localObject1 = ContactEditLabel.this.getString(R.l.gRB);
        kotlin.g.b.s.s(localObject1, "getString(R.string.pref_name_title)");
        localObject1 = cf(paramInt, (String)localObject1);
      }
      for (;;)
      {
        kotlin.g.b.s.checkNotNull(localObject1);
        AppMethodBeat.o(268693);
        return localObject1;
        Object localObject2;
        if (paramInt == 1)
        {
          localObject1 = ContactEditLabel.l(ContactEditLabel.this);
          kotlin.g.b.s.checkNotNull(localObject1);
          localObject1 = new d(paramInt, (String)localObject1);
          ((d)localObject1).JXc = true;
          localObject2 = (d.c)new b(ContactEditLabel.this);
          kotlin.g.b.s.u(localObject2, "textListener");
          ((d)localObject1).JXa = ((d.c)localObject2);
          localObject1 = (com.tencent.mm.ui.contact.a.a)localObject1;
        }
        else if (paramInt == 2)
        {
          localObject1 = cf(paramInt, "标签成员 (" + ContactEditLabel.k(ContactEditLabel.this).size() + ')');
        }
        else if (paramInt == 3)
        {
          localObject1 = new c(paramInt);
          localObject2 = (c.c)new a(ContactEditLabel.this);
          kotlin.g.b.s.u(localObject2, "onAddItemClickListener");
          ((c)localObject1).JWR = ((c.c)localObject2);
          localObject1 = (com.tencent.mm.ui.contact.a.a)localObject1;
        }
        else if (this.JUL.indexOfKey(paramInt) >= 0)
        {
          localObject1 = this.JUL.get(paramInt);
          kotlin.g.b.s.s(localObject1, "posHeaderMap[position]");
          localObject1 = cf(paramInt, (String)localObject1);
        }
        else
        {
          localObject1 = Zx(paramInt);
        }
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/label/ui/ContactEditLabel$OnlyChatContactAdapter$createHeaderAddItem$1", "Lcom/tencent/mm/plugin/label/ui/HeaderAddDataItem$OnAddItemClickListener;", "onClicked", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements c.c
    {
      a(ContactEditLabel paramContactEditLabel) {}
      
      public final void fTj()
      {
        AppMethodBeat.i(268706);
        ContactEditLabel.m(this.JUN);
        AppMethodBeat.o(268706);
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/label/ui/ContactEditLabel$OnlyChatContactAdapter$createHeaderLabelItem$1", "Lcom/tencent/mm/plugin/label/ui/HeaderLabelDataItem$OnEditTextChangedListener;", "OnEditTextChanged", "", "Str", "", "enableSaveBtn", "enable", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements d.c
    {
      b(ContactEditLabel paramContactEditLabel) {}
      
      public final void aJN(String paramString)
      {
        AppMethodBeat.i(268704);
        kotlin.g.b.s.u(paramString, "Str");
        ContactEditLabel.b(this.JUN, paramString);
        paramString = this.JUN;
        String str = ContactEditLabel.l(this.JUN);
        kotlin.g.b.s.checkNotNull(str);
        ContactEditLabel.c(paramString, str);
        AppMethodBeat.o(268704);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/label/ui/ContactEditLabel$bindUIAndSetListener$2", "Landroid/widget/AdapterView$OnItemClickListener;", "onItemClick", "", "parent", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "position", "", "id", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements AdapterView.OnItemClickListener
  {
    b(ContactEditLabel paramContactEditLabel) {}
    
    public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      AppMethodBeat.i(268652);
      Object localObject = new b();
      ((b)localObject).cH(paramAdapterView);
      ((b)localObject).cH(paramView);
      ((b)localObject).sc(paramInt);
      ((b)localObject).hB(paramLong);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/label/ui/ContactEditLabel$bindUIAndSetListener$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).aYj());
      paramView = ContactEditLabel.a(this.JUO);
      paramAdapterView = paramView;
      if (paramView == null)
      {
        kotlin.g.b.s.bIx("adapter");
        paramAdapterView = null;
      }
      paramAdapterView = paramAdapterView.aDt(paramInt);
      if ((paramAdapterView == null) || (!(paramAdapterView instanceof com.tencent.mm.ui.contact.a.f)))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactEditLabel$bindUIAndSetListener$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(268652);
        return;
      }
      localObject = ((com.tencent.mm.ui.contact.a.f)paramAdapterView).username;
      paramView = ContactEditLabel.a(this.JUO);
      paramAdapterView = paramView;
      if (paramView == null)
      {
        kotlin.g.b.s.bIx("adapter");
        paramAdapterView = null;
      }
      if (paramAdapterView.gZe())
      {
        paramView = ContactEditLabel.a(this.JUO);
        paramAdapterView = paramView;
        if (paramView == null)
        {
          kotlin.g.b.s.bIx("adapter");
          paramAdapterView = null;
        }
        kotlin.g.b.s.s(localObject, "username");
        kotlin.g.b.s.u(localObject, "username");
        if (paramAdapterView.JUM.contains(localObject))
        {
          paramAdapterView.JUM.remove(localObject);
          paramAdapterView.notifyDataSetChanged();
          label210:
          paramAdapterView = new Intent();
          paramAdapterView.putExtra("Contact_User", (String)localObject);
          paramAdapterView.putExtra("Contact_Scene", 3);
          paramAdapterView.putExtra("CONTACT_INFO_UI_SOURCE", 4);
          if (localObject != null) {
            if (((CharSequence)localObject).length() <= 0) {
              break label436;
            }
          }
        }
      }
      label436:
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0) {
          com.tencent.mm.br.c.b((Context)this.JUO.getContext(), "profile", ".ui.ContactInfoUI", paramAdapterView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactEditLabel$bindUIAndSetListener$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(268652);
        return;
        paramAdapterView.JUM.add(localObject);
        break;
        if (!au.bwp((String)localObject)) {
          break label210;
        }
        paramView = new Intent((Context)this.JUO.getContext(), AddressUI.class);
        paramView.putExtra("Contact_GroupFilter_DisplayName", "@biz.contact");
        paramAdapterView = this.JUO;
        paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
        com.tencent.mm.hellhoundlib.a.a.b(paramAdapterView, paramView.aYi(), "com/tencent/mm/plugin/label/ui/ContactEditLabel$bindUIAndSetListener$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAdapterView.startActivity((Intent)paramView.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAdapterView, "com/tencent/mm/plugin/label/ui/ContactEditLabel$bindUIAndSetListener$2", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/ContactEditLabel$bindUIAndSetListener$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(268652);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/label/ui/ContactEditLabel$bindUIAndSetListener$3", "Landroid/widget/AdapterView$OnItemLongClickListener;", "onItemLongClick", "", "parent", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "position", "", "id", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements AdapterView.OnItemLongClickListener
  {
    c(ContactEditLabel paramContactEditLabel) {}
    
    public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      AppMethodBeat.i(268648);
      ContactEditLabel.a locala = ContactEditLabel.a(this.JUO);
      paramAdapterView = locala;
      if (locala == null)
      {
        kotlin.g.b.s.bIx("adapter");
        paramAdapterView = null;
      }
      paramAdapterView = paramAdapterView.aDt(paramInt);
      if ((paramAdapterView == null) || (!(paramAdapterView instanceof com.tencent.mm.ui.contact.a.f)))
      {
        AppMethodBeat.o(268648);
        return true;
      }
      final String str = ((com.tencent.mm.ui.contact.a.f)paramAdapterView).username;
      locala = ContactEditLabel.a(this.JUO);
      paramAdapterView = locala;
      if (locala == null)
      {
        kotlin.g.b.s.bIx("adapter");
        paramAdapterView = null;
      }
      if (!paramAdapterView.gZe()) {
        new com.tencent.mm.ui.widget.b.a((Context)this.JUO.getContext()).a(paramView, paramInt, paramLong, (View.OnCreateContextMenuListener)new a(paramInt), (u.i)new b(this.JUO, str), ContactEditLabel.b(this.JUO), ContactEditLabel.c(this.JUO));
      }
      AppMethodBeat.o(268648);
      return true;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/label/ui/ContactEditLabel$bindUIAndSetListener$3$onItemLongClick$1", "Landroid/view/View$OnCreateContextMenuListener;", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements View.OnCreateContextMenuListener
    {
      a(int paramInt) {}
      
      public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
      {
        AppMethodBeat.i(268696);
        kotlin.g.b.s.checkNotNull(paramContextMenu);
        paramContextMenu.add(this.qkg, 0, 0, R.l.fEU);
        AppMethodBeat.o(268696);
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/label/ui/ContactEditLabel$bindUIAndSetListener$3$onItemLongClick$2", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "onMMMenuItemSelected", "", "menuItem", "Landroid/view/MenuItem;", "index", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements u.i
    {
      b(ContactEditLabel paramContactEditLabel, String paramString) {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(268694);
        paramMenuItem = this.JUO;
        String str = str;
        kotlin.g.b.s.s(str, "username");
        ContactEditLabel.a(paramMenuItem, str);
        AppMethodBeat.o(268694);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/label/ui/ContactEditLabel$bindUIAndSetListener$4", "Landroid/view/View$OnTouchListener;", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements View.OnTouchListener
  {
    d(ContactEditLabel paramContactEditLabel) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(268647);
      kotlin.g.b.s.u(paramMotionEvent, "event");
      if (paramMotionEvent.getAction() == 0)
      {
        this.JUO.hideVKB();
        ContactEditLabel.a(this.JUO, (int)paramMotionEvent.getRawX());
        ContactEditLabel.b(this.JUO, (int)paramMotionEvent.getRawY());
      }
      AppMethodBeat.o(268647);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/label/ui/ContactEditLabel$bindUIAndSetListener$5", "Lcom/tencent/mm/ui/base/VerticalScrollBar$OnScollBarTouchListener;", "onScollBarTouch", "", "showHead", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements VerticalScrollBar.a
  {
    e(ContactEditLabel paramContactEditLabel) {}
    
    public final void onScollBarTouch(String paramString)
    {
      Object localObject = null;
      AppMethodBeat.i(268651);
      ContactEditLabel.a locala = ContactEditLabel.a(this.JUO);
      int i;
      if (locala == null)
      {
        kotlin.g.b.s.bIx("adapter");
        locala = null;
        if (((Map)locala.JUK).get(paramString) != null) {
          break label84;
        }
        i = -1;
        label45:
        if (i != -1)
        {
          paramString = ContactEditLabel.d(this.JUO);
          if (paramString != null) {
            break label113;
          }
          kotlin.g.b.s.bIx("listView");
          paramString = localObject;
        }
      }
      label84:
      label113:
      for (;;)
      {
        paramString.setSelection(i);
        AppMethodBeat.o(268651);
        return;
        break;
        paramString = ((Map)locala.JUK).get(paramString);
        kotlin.g.b.s.checkNotNull(paramString);
        i = ((Number)paramString).intValue();
        break label45;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/label/ui/ContactEditLabel$bindUIAndSetListener$6", "Landroid/text/TextWatcher;", "searchEvent", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "getSearchEvent", "()Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "setSearchEvent", "(Lcom/tencent/mm/sdk/platformtools/MTimerHandler;)V", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements TextWatcher
  {
    private MTimerHandler lNo;
    
    f(ContactEditLabel paramContactEditLabel)
    {
      AppMethodBeat.i(268650);
      this.lNo = new MTimerHandler((MTimerHandler.CallBack)new a(this.JUO), false);
      AppMethodBeat.o(268650);
    }
    
    public final void afterTextChanged(Editable paramEditable) {}
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(268656);
      this.lNo.stopTimer();
      this.lNo.startTimer(500L);
      AppMethodBeat.o(268656);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/label/ui/ContactEditLabel$bindUIAndSetListener$6$searchEvent$1", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "onTimerExpired", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements MTimerHandler.CallBack
    {
      a(ContactEditLabel paramContactEditLabel) {}
      
      public final boolean onTimerExpired()
      {
        Object localObject2 = null;
        AppMethodBeat.i(268726);
        Object localObject3 = ContactEditLabel.e(this.JUO);
        Object localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("searchET");
          localObject1 = null;
        }
        localObject3 = ((EditText)localObject1).getText().toString();
        localObject1 = ContactEditLabel.a(this.JUO);
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("adapter");
          localObject1 = localObject2;
        }
        for (;;)
        {
          ((ContactEditLabel.a)localObject1).aEJ((String)localObject3);
          AppMethodBeat.o(268726);
          return false;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/label/ui/ContactEditLabel$bindUIAndSetListener$7", "Landroid/view/MenuItem$OnMenuItemClickListener;", "onMenuItemClick", "", "item", "Landroid/view/MenuItem;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(ContactEditLabel paramContactEditLabel) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(268662);
      this.JUO.hideVKB();
      this.JUO.onBackPressed();
      AppMethodBeat.o(268662);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/label/ui/ContactEditLabel$bindUIAndSetListener$8", "Landroid/view/MenuItem$OnMenuItemClickListener;", "onMenuItemClick", "", "item", "Landroid/view/MenuItem;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements MenuItem.OnMenuItemClickListener
  {
    h(ContactEditLabel paramContactEditLabel) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(268654);
      ContactEditLabel.f(this.JUO);
      AppMethodBeat.o(268654);
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/label/ui/ContactEditLabel$initMemberList$1", "Ljava/lang/Runnable;", "run", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements Runnable
  {
    i(ContactEditLabel paramContactEditLabel) {}
    
    public final void run()
    {
      AppMethodBeat.i(268657);
      ArrayList localArrayList = com.tencent.mm.plugin.label.d.fTa().bxk(ContactEditLabel.g(this.JUN));
      if (localArrayList == null)
      {
        Log.w(ContactEditLabel.h(this.JUN), "result is null");
        AppMethodBeat.o(268657);
        return;
      }
      int k = localArrayList.size() - 1;
      if (k >= 0) {}
      int j;
      for (int i = 0;; i = j)
      {
        j = i + 1;
        kotlin.g.b.s.s(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE((String)localArrayList.get(i)), "service(IMessengerStorag…contactStg.get(result[i])");
        if (j > k)
        {
          ContactEditLabel.a(this.JUN, localArrayList);
          if (ContactEditLabel.i(this.JUN) == null) {
            ContactEditLabel.b(this.JUN, new ArrayList());
          }
          for (;;)
          {
            ContactEditLabel.i(this.JUN).addAll((Collection)localArrayList);
            if (ContactEditLabel.j(this.JUN) != null) {
              ContactEditLabel.j(this.JUN).sendEmptyMessage(this.JUN.JUp);
            }
            AppMethodBeat.o(268657);
            return;
            ContactEditLabel.i(this.JUN).clear();
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/label/ui/ContactEditLabel$mHandler$1", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    extends MMHandler
  {
    j(ContactEditLabel paramContactEditLabel, Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(268660);
      kotlin.g.b.s.u(paramMessage, "msg");
      int i = paramMessage.what;
      switch (i)
      {
      default: 
        Log.w(ContactEditLabel.h(this.JUN), "unknow message. what is:%d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(268660);
        return;
      case 6001: 
        ContactEditLabel.n(this.JUN);
        AppMethodBeat.o(268660);
        return;
      }
      com.tencent.mm.plugin.label.a.pFo.aDx();
      AppMethodBeat.o(268660);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactEditLabel
 * JD-Core Version:    0.7.0.1
 */