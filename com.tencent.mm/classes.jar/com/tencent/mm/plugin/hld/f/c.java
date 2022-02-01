package com.tencent.mm.plugin.hld.f;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/utils/ImeUserDictGenerator;", "", "()V", "TAG", "", "UPDATE_CONTACT_MIN_TIME", "", "contactHashmap", "Ljava/util/HashMap;", "Landroid/util/Pair;", "lastContactChangeTime", "onContactChange", "Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "getOnContactChange", "()Lcom/tencent/mm/sdk/storage/MStorageEx$IOnStorageChange;", "isSender", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "loadContact", "", "loadLocalUserDict", "loadPhoneContactData", "refreshPhoneContactByDay", "startGeneratorLocalUserDict", "dict", "updatePhoneContactData", "IPCLoadContactData", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c Jyj;
  private static final HashMap<String, Pair<String, String>> Jyk;
  private static final MStorageEx.IOnStorageChange yta;
  
  static
  {
    AppMethodBeat.i(311543);
    Jyj = new c();
    Jyk = new HashMap();
    yta = c..ExternalSyntheticLambda0.INSTANCE;
    AppMethodBeat.o(311543);
  }
  
  private static final void a(int paramInt, MStorageEx paramMStorageEx, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.f.c
 * JD-Core Version:    0.7.0.1
 */