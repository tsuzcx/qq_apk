package com.tencent.mm.plugin.finder.view.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.b.a;
import com.tencent.mm.protocal.protobuf.bqq;
import d.g.b.k;
import d.l;
import d.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;", "", "()V", "atContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "Lkotlin/collections/ArrayList;", "getAtContactList", "()Ljava/util/ArrayList;", "atContactMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "atNicknameTypeList", "Lkotlin/Pair;", "", "getAtNicknameTypeList", "setAtNicknameTypeList", "(Ljava/util/ArrayList;)V", "atNicknameTypeMap", "getAtNicknameTypeMap", "()Ljava/util/HashMap;", "setAtNicknameTypeMap", "(Ljava/util/HashMap;)V", "atStringInfoList", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "getAtStringInfoList", "setAtStringInfoList", "enterAtPageNum", "getEnterAtPageNum", "()I", "setEnterAtPageNum", "(I)V", "enterSucAtPageNum", "getEnterSucAtPageNum", "setEnterSucAtPageNum", "addAtContact", "", "atContact", "extractTopicAndSetSpan", "curDesc", "s", "Landroid/text/Editable;", "getAtContactListIncludeType", "getExistAtContact", "Lcom/tencent/mm/plugin/finder/utils/LocalFinderAtContactParcel;", "handleAtAction", "type", "username", "restoreAtContactMap", "atContactParcelList", "Companion", "plugin-finder_release"})
public final class a
{
  public static final String TAG = "Finder.FinderAtManager";
  public static final a.a saP;
  public final HashMap<String, bqq> saI;
  public final ArrayList<bqq> saJ;
  public ArrayList<b.a> saK;
  public int saL;
  public int saM;
  private ArrayList<o<String, Integer>> saN;
  private HashMap<String, ArrayList<Integer>> saO;
  
  static
  {
    AppMethodBeat.i(204344);
    saP = new a.a((byte)0);
    TAG = "Finder.FinderAtManager";
    AppMethodBeat.o(204344);
  }
  
  public a()
  {
    AppMethodBeat.i(204343);
    this.saI = new HashMap(5);
    this.saJ = new ArrayList();
    this.saK = new ArrayList();
    this.saN = new ArrayList();
    this.saO = new HashMap();
    AppMethodBeat.o(204343);
  }
  
  public final void aY(int paramInt, String paramString)
  {
    AppMethodBeat.i(204340);
    k.h(paramString, "username");
    this.saL += 1;
    ArrayList localArrayList;
    if (paramInt != 0)
    {
      this.saM += 1;
      this.saN.add(new o(paramString, Integer.valueOf(paramInt)));
      localArrayList = (ArrayList)this.saO.get(paramString);
      if (localArrayList != null) {
        break label109;
      }
      localArrayList = new ArrayList();
    }
    label109:
    for (;;)
    {
      localArrayList.add(Integer.valueOf(paramInt));
      ((Map)this.saO).put(paramString, localArrayList);
      AppMethodBeat.o(204340);
      return;
    }
  }
  
  public final ArrayList<bqq> cFr()
  {
    AppMethodBeat.i(204342);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.saJ.iterator();
    while (localIterator.hasNext())
    {
      bqq localbqq = (bqq)localIterator.next();
      localArrayList.add(localbqq);
      Object localObject = (ArrayList)this.saO.get(localbqq.username);
      if (localObject == null)
      {
        localbqq.type = 1;
      }
      else if (((ArrayList)localObject).size() > 0)
      {
        localObject = ((ArrayList)localObject).remove(0);
        k.g(localObject, "types.removeAt(0)");
        localbqq.type = ((Number)localObject).intValue();
      }
    }
    localArrayList = this.saJ;
    AppMethodBeat.o(204342);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.a
 * JD-Core Version:    0.7.0.1
 */