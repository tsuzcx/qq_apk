package com.tencent.mm.plugin.finder.view.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.e.a;
import com.tencent.mm.protocal.protobuf.cse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;", "", "()V", "atContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "Lkotlin/collections/ArrayList;", "getAtContactList", "()Ljava/util/ArrayList;", "atContactMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "atNicknameTypeList", "Lkotlin/Pair;", "", "getAtNicknameTypeList", "setAtNicknameTypeList", "(Ljava/util/ArrayList;)V", "atNicknameTypeMap", "getAtNicknameTypeMap", "()Ljava/util/HashMap;", "setAtNicknameTypeMap", "(Ljava/util/HashMap;)V", "atStringInfoList", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "getAtStringInfoList", "setAtStringInfoList", "enterAtPageNum", "getEnterAtPageNum", "()I", "setEnterAtPageNum", "(I)V", "enterSucAtPageNum", "getEnterSucAtPageNum", "setEnterSucAtPageNum", "addAtContact", "", "atContact", "extractTopicAndSetSpan", "curDesc", "s", "Landroid/text/Editable;", "getAtContactListIncludeType", "getExistAtContact", "Lcom/tencent/mm/plugin/finder/utils/LocalFinderAtContactParcel;", "handleAtAction", "type", "nickname", "restoreAtContactMap", "atContactParcelList", "Companion", "plugin-finder_release"})
public final class b
{
  public static final a Bfd;
  public static final String TAG = "Finder.FinderAtManager";
  public final ArrayList<cse> ABf;
  public final HashMap<String, cse> BeX;
  ArrayList<e.a> BeY;
  public int BeZ;
  public int Bfa;
  private ArrayList<o<String, Integer>> Bfb;
  private HashMap<String, ArrayList<Integer>> Bfc;
  
  static
  {
    AppMethodBeat.i(229197);
    Bfd = new a((byte)0);
    TAG = "Finder.FinderAtManager";
    AppMethodBeat.o(229197);
  }
  
  public b()
  {
    AppMethodBeat.i(229196);
    this.BeX = new HashMap(5);
    this.ABf = new ArrayList();
    this.BeY = new ArrayList();
    this.Bfb = new ArrayList();
    this.Bfc = new HashMap();
    AppMethodBeat.o(229196);
  }
  
  public final void be(int paramInt, String paramString)
  {
    AppMethodBeat.i(229176);
    p.k(paramString, "nickname");
    this.BeZ += 1;
    ArrayList localArrayList;
    if (paramInt != 0)
    {
      this.Bfa += 1;
      this.Bfb.add(new o(paramString, Integer.valueOf(paramInt)));
      localArrayList = (ArrayList)this.Bfc.get(paramString);
      if (localArrayList != null) {
        break label109;
      }
      localArrayList = new ArrayList();
    }
    label109:
    for (;;)
    {
      localArrayList.add(Integer.valueOf(paramInt));
      ((Map)this.Bfc).put(paramString, localArrayList);
      AppMethodBeat.o(229176);
      return;
    }
  }
  
  public final ArrayList<cse> ejK()
  {
    AppMethodBeat.i(229189);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.ABf.iterator();
    while (localIterator.hasNext())
    {
      cse localcse = (cse)localIterator.next();
      localArrayList.add(localcse);
      Object localObject = (ArrayList)((Map)this.Bfc).get(localcse.nickname);
      if (localObject == null)
      {
        localcse.type = 1;
      }
      else if (((ArrayList)localObject).size() > 0)
      {
        localObject = ((ArrayList)localObject).remove(0);
        p.j(localObject, "types.removeAt(0)");
        localcse.type = ((Number)localObject).intValue();
      }
    }
    localArrayList = this.ABf;
    AppMethodBeat.o(229189);
    return localArrayList;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.b
 * JD-Core Version:    0.7.0.1
 */