package com.tencent.mm.plugin.finder.view.manager;

import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.n.a;
import com.tencent.mm.protocal.protobuf.ebc;
import d.g.a.q;
import d.g.b.k;
import d.o;
import d.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager;", "", "()V", "atContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "Lkotlin/collections/ArrayList;", "getAtContactList", "()Ljava/util/ArrayList;", "atContactMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "atNicknameTypeList", "Lkotlin/Pair;", "", "getAtNicknameTypeList", "setAtNicknameTypeList", "(Ljava/util/ArrayList;)V", "atNicknameTypeMap", "getAtNicknameTypeMap", "()Ljava/util/HashMap;", "setAtNicknameTypeMap", "(Ljava/util/HashMap;)V", "atStringInfoList", "Lcom/tencent/mm/plugin/finder/utils/FinderAtUtil$AtStringInfo;", "getAtStringInfoList", "setAtStringInfoList", "enterAtPageNum", "getEnterAtPageNum", "()I", "setEnterAtPageNum", "(I)V", "enterSucAtPageNum", "getEnterSucAtPageNum", "setEnterSucAtPageNum", "addAtContact", "", "atContact", "extractTopicAndSetSpan", "curDesc", "s", "Landroid/text/Editable;", "getAtContactListIncludeType", "getExistAtContact", "Lcom/tencent/mm/plugin/finder/utils/LocalFinderAtContactParcel;", "handleAtAction", "type", "username", "restoreAtContactMap", "atContactParcelList", "Companion", "plugin-finder_release"})
public final class c
{
  public static final a LgO;
  public static final String TAG = "Finder.FinderAtManager";
  public final HashMap<String, ebc> LgH;
  public final ArrayList<ebc> LgI;
  public ArrayList<n.a> LgJ;
  public int LgK;
  public int LgL;
  private ArrayList<o<String, Integer>> LgM;
  private HashMap<String, ArrayList<Integer>> LgN;
  
  static
  {
    AppMethodBeat.i(200274);
    LgO = new a((byte)0);
    TAG = "Finder.FinderAtManager";
    AppMethodBeat.o(200274);
  }
  
  public c()
  {
    AppMethodBeat.i(200273);
    this.LgH = new HashMap(5);
    this.LgI = new ArrayList();
    this.LgJ = new ArrayList();
    this.LgM = new ArrayList();
    this.LgN = new HashMap();
    AppMethodBeat.o(200273);
  }
  
  public final void cV(int paramInt, String paramString)
  {
    AppMethodBeat.i(200270);
    k.h(paramString, "username");
    this.LgK += 1;
    ArrayList localArrayList;
    if (paramInt != 0)
    {
      this.LgL += 1;
      this.LgM.add(new o(paramString, Integer.valueOf(paramInt)));
      localArrayList = (ArrayList)this.LgN.get(paramString);
      if (localArrayList != null) {
        break label109;
      }
      localArrayList = new ArrayList();
    }
    label109:
    for (;;)
    {
      localArrayList.add(Integer.valueOf(paramInt));
      ((Map)this.LgN).put(paramString, localArrayList);
      AppMethodBeat.o(200270);
      return;
    }
  }
  
  public final ArrayList<ebc> fXb()
  {
    AppMethodBeat.i(200272);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.LgI.iterator();
    while (localIterator.hasNext())
    {
      ebc localebc = (ebc)localIterator.next();
      localArrayList.add(localebc);
      Object localObject = (ArrayList)this.LgN.get(localebc.username);
      if (localObject == null)
      {
        localebc.type = 1;
      }
      else if (((ArrayList)localObject).size() > 0)
      {
        localObject = ((ArrayList)localObject).remove(0);
        k.g(localObject, "types.removeAt(0)");
        localebc.type = ((Number)localObject).intValue();
      }
    }
    localArrayList = this.LgI;
    AppMethodBeat.o(200272);
    return localArrayList;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/manager/FinderAtManager$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "start", "", "end", "nickname", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements q<Integer, Integer, String, y>
  {
    b(Spannable paramSpannable)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.c
 * JD-Core Version:    0.7.0.1
 */