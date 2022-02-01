package com.tencent.mm.plugin.hld.ui;

import android.content.Intent;
import androidx.lifecycle.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.protocal.protobuf.dzc;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/ui/ContactWidgetWxIme;", "Lcom/tencent/mm/pluginsdk/deprecated/IBodyWidget;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/ILoadingOpLogService$IOplogBatchResult;", "context", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "handleEvent", "", "key", "", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "contact", "Lcom/tencent/mm/storage/Contact;", "readonly", "addContactScene", "onDetach", "onOpLogResult", "rets", "Ljava/util/LinkedList;", "oplogErrMsgs", "Lcom/tencent/mm/protocal/protobuf/OplogErrMsg;", "operations", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IOpLogStorage$Operation;", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ContactWidgetWxIme
  implements p, h.a, a
{
  public static final ContactWidgetWxIme.a Jxp;
  
  static
  {
    AppMethodBeat.i(312422);
    Jxp = new ContactWidgetWxIme.a((byte)0);
    AppMethodBeat.o(312422);
  }
  
  public final boolean a(f paramf, au paramau, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(312446);
    s.u(paramf, "screen");
    s.u(paramau, "contact");
    AppMethodBeat.o(312446);
    return true;
  }
  
  public final boolean anl(String paramString)
  {
    return true;
  }
  
  public final boolean dvq()
  {
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onOpLogResult(LinkedList<Integer> paramLinkedList, LinkedList<dzc> paramLinkedList1, ArrayList<k.b> paramArrayList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.ui.ContactWidgetWxIme
 * JD-Core Version:    0.7.0.1
 */