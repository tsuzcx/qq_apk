package com.tencent.mm.plugin.hld.ui;

import android.content.Intent;
import androidx.lifecycle.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.pluginsdk.c.a;
import com.tencent.mm.protocal.protobuf.dgv;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.f;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/ui/ContactWidgetWxIme;", "Lcom/tencent/mm/pluginsdk/deprecated/IBodyWidget;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/ILoadingOpLogService$IOplogBatchResult;", "context", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "handleEvent", "", "key", "", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "contact", "Lcom/tencent/mm/storage/Contact;", "readonly", "addContactScene", "onDetach", "onOpLogResult", "rets", "Ljava/util/LinkedList;", "oplogErrMsgs", "Lcom/tencent/mm/protocal/protobuf/OplogErrMsg;", "operations", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IOpLogStorage$Operation;", "Companion", "plugin-hld_release"})
public final class ContactWidgetWxIme
  implements k, h.a, a
{
  public static final a DFI;
  
  static
  {
    AppMethodBeat.i(210185);
    DFI = new a((byte)0);
    AppMethodBeat.o(210185);
  }
  
  public final void a(LinkedList<Integer> paramLinkedList, LinkedList<dgv> paramLinkedList1, ArrayList<k.b> paramArrayList) {}
  
  public final boolean a(f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(210178);
    p.k(paramf, "screen");
    p.k(paramas, "contact");
    AppMethodBeat.o(210178);
    return true;
  }
  
  public final boolean atw(String paramString)
  {
    return true;
  }
  
  public final boolean cQX()
  {
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/ui/ContactWidgetWxIme$Companion;", "", "()V", "KEY_HEADER_HELPER", "", "KEY_INSTALL", "KEY_KEYBOARD_CLEAR_PERSONAL_DICT", "KEY_KEYBOARD_PRIVACY", "KEY_KEYBOARD_SETTING", "KEY_UNINSTALL", "REQUEST_CODE_ACTIVE_FIFTH_PROCESS_ACTIVE", "", "REQUEST_CODE_ACTIVE_FIRST_PROCESS_PRIVACY_INFO", "REQUEST_CODE_ACTIVE_SECOND_PROCESS_COLLECT_DATA", "REQUEST_CODE_ACTIVE_THIRD_PROCESS_ACTIVE", "TAG", "plugin-hld_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.ui.ContactWidgetWxIme
 * JD-Core Version:    0.7.0.1
 */