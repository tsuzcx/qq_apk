package com.tencent.mm.plugin.finder.view.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.b.a;
import com.tencent.mm.protocal.protobuf.bvx;
import d.g.b.p;
import d.l;
import d.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;", "", "()V", "atContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "Lkotlin/collections/ArrayList;", "getAtContactList", "()Ljava/util/ArrayList;", "atContactMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "atNicknameTypeList", "Lkotlin/Pair;", "", "getAtNicknameTypeList", "setAtNicknameTypeList", "(Ljava/util/ArrayList;)V", "atNicknameTypeMap", "getAtNicknameTypeMap", "()Ljava/util/HashMap;", "setAtNicknameTypeMap", "(Ljava/util/HashMap;)V", "atStringInfoList", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "getAtStringInfoList", "setAtStringInfoList", "enterAtPageNum", "getEnterAtPageNum", "()I", "setEnterAtPageNum", "(I)V", "enterSucAtPageNum", "getEnterSucAtPageNum", "setEnterSucAtPageNum", "addAtContact", "", "atContact", "extractTopicAndSetSpan", "curDesc", "s", "Landroid/text/Editable;", "getAtContactListIncludeType", "getExistAtContact", "Lcom/tencent/mm/plugin/finder/utils/LocalFinderAtContactParcel;", "handleAtAction", "type", "username", "restoreAtContactMap", "atContactParcelList", "Companion", "plugin-finder_release"})
public final class a
{
  public static final String TAG = "Finder.FinderAtManager";
  public static final a.a tjs;
  public final HashMap<String, bvx> tjl;
  public final ArrayList<bvx> tjm;
  public ArrayList<b.a> tjn;
  public int tjo;
  public int tjp;
  private ArrayList<o<String, Integer>> tjq;
  private HashMap<String, ArrayList<Integer>> tjr;
  
  static
  {
    AppMethodBeat.i(205994);
    tjs = new a.a((byte)0);
    TAG = "Finder.FinderAtManager";
    AppMethodBeat.o(205994);
  }
  
  public a()
  {
    AppMethodBeat.i(205993);
    this.tjl = new HashMap(5);
    this.tjm = new ArrayList();
    this.tjn = new ArrayList();
    this.tjq = new ArrayList();
    this.tjr = new HashMap();
    AppMethodBeat.o(205993);
  }
  
  public final void ba(int paramInt, String paramString)
  {
    AppMethodBeat.i(205990);
    p.h(paramString, "username");
    this.tjo += 1;
    ArrayList localArrayList;
    if (paramInt != 0)
    {
      this.tjp += 1;
      this.tjq.add(new o(paramString, Integer.valueOf(paramInt)));
      localArrayList = (ArrayList)this.tjr.get(paramString);
      if (localArrayList != null) {
        break label109;
      }
      localArrayList = new ArrayList();
    }
    label109:
    for (;;)
    {
      localArrayList.add(Integer.valueOf(paramInt));
      ((Map)this.tjr).put(paramString, localArrayList);
      AppMethodBeat.o(205990);
      return;
    }
  }
  
  public final ArrayList<bvx> cQy()
  {
    AppMethodBeat.i(205992);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.tjm.iterator();
    while (localIterator.hasNext())
    {
      bvx localbvx = (bvx)localIterator.next();
      localArrayList.add(localbvx);
      Object localObject = (ArrayList)((Map)this.tjr).get(localbvx.username);
      if (localObject == null)
      {
        localbvx.type = 1;
      }
      else if (((ArrayList)localObject).size() > 0)
      {
        localObject = ((ArrayList)localObject).remove(0);
        p.g(localObject, "types.removeAt(0)");
        localbvx.type = ((Number)localObject).intValue();
      }
    }
    localArrayList = this.tjm;
    AppMethodBeat.o(205992);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.a
 * JD-Core Version:    0.7.0.1
 */