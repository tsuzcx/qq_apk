package com.tencent.mm.plugin.finder.view.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.h.a;
import com.tencent.mm.protocal.protobuf.djg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;", "", "()V", "atContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "Lkotlin/collections/ArrayList;", "getAtContactList", "()Ljava/util/ArrayList;", "atContactMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "atNicknameTypeList", "Lkotlin/Pair;", "", "getAtNicknameTypeList", "setAtNicknameTypeList", "(Ljava/util/ArrayList;)V", "atNicknameTypeMap", "getAtNicknameTypeMap", "()Ljava/util/HashMap;", "setAtNicknameTypeMap", "(Ljava/util/HashMap;)V", "atStringInfoList", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "getAtStringInfoList", "setAtStringInfoList", "enterAtPageNum", "getEnterAtPageNum", "()I", "setEnterAtPageNum", "(I)V", "enterSucAtPageNum", "getEnterSucAtPageNum", "setEnterSucAtPageNum", "addAtContact", "", "atContact", "extractTopicAndSetSpan", "curDesc", "s", "Landroid/text/Editable;", "getAtContactListIncludeType", "getExistAtContact", "Lcom/tencent/mm/plugin/finder/utils/LocalFinderAtContactParcel;", "handleAtAction", "type", "nickname", "restoreAtContactMap", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "atContactParcelList", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a GHB;
  public static final String TAG;
  public final HashMap<String, djg> GHC;
  ArrayList<h.a> GHD;
  public int GHE;
  public int GHF;
  private ArrayList<r<String, Integer>> GHG;
  private HashMap<String, ArrayList<Integer>> GHH;
  public final ArrayList<djg> Gct;
  
  static
  {
    AppMethodBeat.i(346130);
    GHB = new b.a((byte)0);
    TAG = "Finder.FinderAtManager";
    AppMethodBeat.o(346130);
  }
  
  public b()
  {
    AppMethodBeat.i(346116);
    this.GHC = new HashMap(5);
    this.Gct = new ArrayList();
    this.GHD = new ArrayList();
    this.GHG = new ArrayList();
    this.GHH = new HashMap();
    AppMethodBeat.o(346116);
  }
  
  public final void bI(int paramInt, String paramString)
  {
    AppMethodBeat.i(346140);
    s.u(paramString, "nickname");
    this.GHE += 1;
    ArrayList localArrayList;
    if (paramInt != 0)
    {
      this.GHF += 1;
      this.GHG.add(new r(paramString, Integer.valueOf(paramInt)));
      localArrayList = (ArrayList)this.GHH.get(paramString);
      if (localArrayList != null) {
        break label109;
      }
      localArrayList = new ArrayList();
    }
    label109:
    for (;;)
    {
      localArrayList.add(Integer.valueOf(paramInt));
      ((Map)this.GHH).put(paramString, localArrayList);
      AppMethodBeat.o(346140);
      return;
    }
  }
  
  public final ArrayList<djg> flX()
  {
    AppMethodBeat.i(346150);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Gct.iterator();
    while (localIterator.hasNext())
    {
      djg localdjg = (djg)localIterator.next();
      localArrayList.add(localdjg);
      Object localObject = (ArrayList)((Map)this.GHH).get(localdjg.nickname);
      if (localObject == null)
      {
        localdjg.type = 1;
      }
      else if (((ArrayList)localObject).size() > 0)
      {
        localObject = ((ArrayList)localObject).remove(0);
        s.s(localObject, "types.removeAt(0)");
        localdjg.type = ((Number)localObject).intValue();
      }
    }
    localArrayList = this.Gct;
    AppMethodBeat.o(346150);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.b
 * JD-Core Version:    0.7.0.1
 */