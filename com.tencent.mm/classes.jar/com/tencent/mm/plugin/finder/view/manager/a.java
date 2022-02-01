package com.tencent.mm.plugin.finder.view.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.b.a;
import com.tencent.mm.protocal.protobuf.bvd;
import d.g.b.p;
import d.l;
import d.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;", "", "()V", "atContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "Lkotlin/collections/ArrayList;", "getAtContactList", "()Ljava/util/ArrayList;", "atContactMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "atNicknameTypeList", "Lkotlin/Pair;", "", "getAtNicknameTypeList", "setAtNicknameTypeList", "(Ljava/util/ArrayList;)V", "atNicknameTypeMap", "getAtNicknameTypeMap", "()Ljava/util/HashMap;", "setAtNicknameTypeMap", "(Ljava/util/HashMap;)V", "atStringInfoList", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "getAtStringInfoList", "setAtStringInfoList", "enterAtPageNum", "getEnterAtPageNum", "()I", "setEnterAtPageNum", "(I)V", "enterSucAtPageNum", "getEnterSucAtPageNum", "setEnterSucAtPageNum", "addAtContact", "", "atContact", "extractTopicAndSetSpan", "curDesc", "s", "Landroid/text/Editable;", "getAtContactListIncludeType", "getExistAtContact", "Lcom/tencent/mm/plugin/finder/utils/LocalFinderAtContactParcel;", "handleAtAction", "type", "username", "restoreAtContactMap", "atContactParcelList", "Companion", "plugin-finder_release"})
public final class a
{
  public static final String TAG = "Finder.FinderAtManager";
  public static final a sYe;
  public final HashMap<String, bvd> sXX;
  public final ArrayList<bvd> sXY;
  public ArrayList<b.a> sXZ;
  public int sYa;
  public int sYb;
  private ArrayList<o<String, Integer>> sYc;
  private HashMap<String, ArrayList<Integer>> sYd;
  
  static
  {
    AppMethodBeat.i(205351);
    sYe = new a((byte)0);
    TAG = "Finder.FinderAtManager";
    AppMethodBeat.o(205351);
  }
  
  public a()
  {
    AppMethodBeat.i(205350);
    this.sXX = new HashMap(5);
    this.sXY = new ArrayList();
    this.sXZ = new ArrayList();
    this.sYc = new ArrayList();
    this.sYd = new HashMap();
    AppMethodBeat.o(205350);
  }
  
  public final void bb(int paramInt, String paramString)
  {
    AppMethodBeat.i(205347);
    p.h(paramString, "username");
    this.sYa += 1;
    ArrayList localArrayList;
    if (paramInt != 0)
    {
      this.sYb += 1;
      this.sYc.add(new o(paramString, Integer.valueOf(paramInt)));
      localArrayList = (ArrayList)this.sYd.get(paramString);
      if (localArrayList != null) {
        break label109;
      }
      localArrayList = new ArrayList();
    }
    label109:
    for (;;)
    {
      localArrayList.add(Integer.valueOf(paramInt));
      ((Map)this.sYd).put(paramString, localArrayList);
      AppMethodBeat.o(205347);
      return;
    }
  }
  
  public final ArrayList<bvd> cNO()
  {
    AppMethodBeat.i(205349);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.sXY.iterator();
    while (localIterator.hasNext())
    {
      bvd localbvd = (bvd)localIterator.next();
      localArrayList.add(localbvd);
      Object localObject = (ArrayList)this.sYd.get(localbvd.username);
      if (localObject == null)
      {
        localbvd.type = 1;
      }
      else if (((ArrayList)localObject).size() > 0)
      {
        localObject = ((ArrayList)localObject).remove(0);
        p.g(localObject, "types.removeAt(0)");
        localbvd.type = ((Number)localObject).intValue();
      }
    }
    localArrayList = this.sXY;
    AppMethodBeat.o(205349);
    return localArrayList;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.a
 * JD-Core Version:    0.7.0.1
 */