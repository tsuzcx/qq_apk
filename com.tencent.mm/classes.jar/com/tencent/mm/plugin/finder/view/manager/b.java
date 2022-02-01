package com.tencent.mm.plugin.finder.view.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.d.a;
import com.tencent.mm.protocal.protobuf.cjj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;", "", "()V", "atContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "Lkotlin/collections/ArrayList;", "getAtContactList", "()Ljava/util/ArrayList;", "atContactMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "atNicknameTypeList", "Lkotlin/Pair;", "", "getAtNicknameTypeList", "setAtNicknameTypeList", "(Ljava/util/ArrayList;)V", "atNicknameTypeMap", "getAtNicknameTypeMap", "()Ljava/util/HashMap;", "setAtNicknameTypeMap", "(Ljava/util/HashMap;)V", "atStringInfoList", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "getAtStringInfoList", "setAtStringInfoList", "enterAtPageNum", "getEnterAtPageNum", "()I", "setEnterAtPageNum", "(I)V", "enterSucAtPageNum", "getEnterSucAtPageNum", "setEnterSucAtPageNum", "addAtContact", "", "atContact", "extractTopicAndSetSpan", "curDesc", "s", "Landroid/text/Editable;", "getAtContactListIncludeType", "getExistAtContact", "Lcom/tencent/mm/plugin/finder/utils/LocalFinderAtContactParcel;", "handleAtAction", "type", "nickname", "restoreAtContactMap", "atContactParcelList", "Companion", "plugin-finder_release"})
public final class b
{
  public static final String TAG = "Finder.FinderAtManager";
  public static final a wsM;
  public final ArrayList<cjj> vTC;
  public final HashMap<String, cjj> wsG;
  ArrayList<d.a> wsH;
  public int wsI;
  public int wsJ;
  private ArrayList<o<String, Integer>> wsK;
  private HashMap<String, ArrayList<Integer>> wsL;
  
  static
  {
    AppMethodBeat.i(255252);
    wsM = new a((byte)0);
    TAG = "Finder.FinderAtManager";
    AppMethodBeat.o(255252);
  }
  
  public b()
  {
    AppMethodBeat.i(255251);
    this.wsG = new HashMap(5);
    this.vTC = new ArrayList();
    this.wsH = new ArrayList();
    this.wsK = new ArrayList();
    this.wsL = new HashMap();
    AppMethodBeat.o(255251);
  }
  
  public final void be(int paramInt, String paramString)
  {
    AppMethodBeat.i(255248);
    p.h(paramString, "nickname");
    this.wsI += 1;
    ArrayList localArrayList;
    if (paramInt != 0)
    {
      this.wsJ += 1;
      this.wsK.add(new o(paramString, Integer.valueOf(paramInt)));
      localArrayList = (ArrayList)this.wsL.get(paramString);
      if (localArrayList != null) {
        break label109;
      }
      localArrayList = new ArrayList();
    }
    label109:
    for (;;)
    {
      localArrayList.add(Integer.valueOf(paramInt));
      ((Map)this.wsL).put(paramString, localArrayList);
      AppMethodBeat.o(255248);
      return;
    }
  }
  
  public final ArrayList<cjj> dHz()
  {
    AppMethodBeat.i(255250);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.vTC.iterator();
    while (localIterator.hasNext())
    {
      cjj localcjj = (cjj)localIterator.next();
      localArrayList.add(localcjj);
      Object localObject = (ArrayList)((Map)this.wsL).get(localcjj.nickname);
      if (localObject == null)
      {
        localcjj.type = 1;
      }
      else if (((ArrayList)localObject).size() > 0)
      {
        localObject = ((ArrayList)localObject).remove(0);
        p.g(localObject, "types.removeAt(0)");
        localcjj.type = ((Number)localObject).intValue();
      }
    }
    localArrayList = this.vTC;
    AppMethodBeat.o(255250);
    return localArrayList;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.b
 * JD-Core Version:    0.7.0.1
 */