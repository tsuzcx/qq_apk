package com.tencent.mm.plugin.messenger.b;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.a.e.a;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.plugin.messenger.a.e.c;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class a
  implements e
{
  private Map<String, LinkedList<e.b>> oEa;
  private Map<String, LinkedList<e.a>> oEb;
  private Map<String, HashSet<e.c>> oEc;
  private com.tencent.mm.at.a.d.a<Long, CharSequence> oEd;
  private com.tencent.mm.at.a.d.a<Long, CharSequence> oEe;
  public o oEf;
  
  public a()
  {
    AppMethodBeat.i(136923);
    this.oEa = new HashMap();
    this.oEb = new HashMap();
    this.oEc = new HashMap();
    this.oEd = new com.tencent.mm.at.a.d.a(200);
    this.oEe = new com.tencent.mm.at.a.d.a(500);
    this.oEf = new a.1(this);
    AppMethodBeat.o(136923);
  }
  
  private static void H(CharSequence paramCharSequence)
  {
    int i = 0;
    AppMethodBeat.i(136934);
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0) && ((paramCharSequence instanceof Spanned)))
    {
      paramCharSequence = (ClickableSpan[])((Spanned)paramCharSequence).getSpans(0, paramCharSequence.length(), ClickableSpan.class);
      if ((paramCharSequence != null) && (paramCharSequence.length > 0))
      {
        int j = paramCharSequence.length;
        while (i < j)
        {
          if (!(paramCharSequence[i] instanceof com.tencent.mm.ui.base.a.a))
          {
            paramCharSequence = new IllegalArgumentException("hy: actively throw Exception!!! all clickable spans must be instance of com.tencent.mm.ui.base.span.IPressableSpan!");
            AppMethodBeat.o(136934);
            throw paramCharSequence;
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(136934);
  }
  
  private static boolean TO(String paramString)
  {
    AppMethodBeat.i(136937);
    if (("tmpl_type_profile".equals(paramString)) || ("tmpl_type_profilewithrevoke".equals(paramString)) || ("tmpl_type_profilewithrevokeqrcode".equals(paramString)) || ("tmpl_type_wxappnotifywithview".equals(paramString)) || ("tmpl_type_succeed_contact".equals(paramString)) || ("tmpl_type_jump_chat".equals(paramString)))
    {
      AppMethodBeat.o(136937);
      return true;
    }
    AppMethodBeat.o(136937);
    return false;
  }
  
  private static boolean TP(String paramString)
  {
    AppMethodBeat.i(136938);
    if (("link_profile".equals(paramString)) || ("link_revoke".equals(paramString)) || ("link_revoke_qrcode".equals(paramString)) || ("link_plain".equals(paramString)) || ("link_view_wxapp".equals(paramString)) || ("link_succeed_contact".equals(paramString)) || ("link_jump_chat".equals(paramString)) || ("link_admin_explain".equals(paramString)))
    {
      AppMethodBeat.o(136938);
      return true;
    }
    AppMethodBeat.o(136938);
    return false;
  }
  
  private CharSequence a(Map<String, String> paramMap, Bundle paramBundle, WeakReference<Context> paramWeakReference, int paramInt)
  {
    AppMethodBeat.i(136932);
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    Object localObject2 = new StringBuilder();
    Object localObject1;
    if (i == 0)
    {
      localObject1 = "";
      label35:
      localObject1 = localObject1;
      localObject1 = ".sysmsg.sysmsgtemplate.content_template" + (String)localObject1;
      if (bo.isNullOrNil((String)paramMap.get(localObject1))) {
        break label868;
      }
      localObject2 = (String)paramMap.get((String)localObject1 + ".$type");
      if (!TO((String)localObject2))
      {
        ab.w("MicroMsg.SysMsgTemplateImp", "hy: non supported type: %s", new Object[] { localObject2 });
        localArrayList1.add(s((String)localObject1, paramMap));
      }
      localObject1 = (String)paramMap.get((String)localObject1 + ".template");
      ab.v("MicroMsg.SysMsgTemplateImp", "hy: rawTemplate : %s", new Object[] { localObject1 });
      localObject1 = b.TQ((String)localObject1);
      if (localObject1 != null) {
        break label281;
      }
    }
    label281:
    for (int j = 0;; j = ((ArrayList)localObject1).size())
    {
      ab.d("MicroMsg.SysMsgTemplateImp", "hy: parsed %d models", new Object[] { Integer.valueOf(j) });
      if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0)) {
        break label291;
      }
      localArrayList1.add(new SpannableString(""));
      i += 1;
      break;
      localObject1 = Integer.valueOf(i);
      break label35;
    }
    label291:
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = ((ArrayList)localObject1).iterator();
    label657:
    label914:
    label915:
    for (;;)
    {
      label307:
      b.a locala;
      if (localIterator.hasNext())
      {
        locala = (b.a)localIterator.next();
        if (locala.type == 0)
        {
          localArrayList2.add(new SpannableString(j.b(ah.getContext(), locala.content)));
          continue;
        }
        if (locala.type == 1)
        {
          j = 0;
          localObject1 = ".sysmsg.sysmsgtemplate.content_template" + ".link_list.link";
          if (j == 0) {
            break label914;
          }
          localObject1 = (String)localObject1 + j;
        }
      }
      for (;;)
      {
        if (bo.isNullOrNil((String)paramMap.get(localObject1))) {
          break label915;
        }
        localObject2 = (String)paramMap.get((String)localObject1 + ".$name");
        String str;
        label556:
        boolean bool;
        if (locala.content.equals(localObject2))
        {
          str = (String)paramMap.get((String)localObject1 + ".$type");
          if (paramInt != 0) {
            break label696;
          }
          localObject2 = (List)this.oEa.get(str);
          if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
            break label632;
          }
          localObject2 = null;
          if ((TP(str)) && (localObject2 != null)) {
            break label663;
          }
          str = bo.bf(str, "");
          if (localObject2 != null) {
            break label657;
          }
          bool = true;
          label586:
          ab.i("MicroMsg.SysMsgTemplateImp", "alvinluo not support link type: %s or listener == null: %b", new Object[] { str, Boolean.valueOf(bool) });
          localArrayList2.add(s((String)localObject1, paramMap));
        }
        label789:
        for (;;)
        {
          j += 1;
          break;
          label632:
          localObject2 = (e.b)((LinkedList)this.oEa.get(str)).getLast();
          break label556;
          bool = false;
          break label586;
          label663:
          localObject1 = ((e.b)localObject2).a(paramMap, (String)localObject1, paramBundle, paramWeakReference);
          H((CharSequence)localObject1);
          localArrayList2.add(nullAsNil((CharSequence)localObject1));
          continue;
          label696:
          if (paramInt == 1)
          {
            localObject2 = (List)this.oEb.get(str);
            if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {}
            for (localObject2 = null;; localObject2 = (e.a)((LinkedList)this.oEb.get(str)).getLast())
            {
              if ((TP(str)) && (localObject2 != null)) {
                break label789;
              }
              localArrayList2.add(s((String)localObject1, paramMap));
              break;
            }
            localArrayList2.add(bo.nullAsNil(((e.a)localObject2).g(paramMap, (String)localObject1)));
          }
          else
          {
            ab.e("MicroMsg.SysMsgTemplateImp", "hy: not supported digest type");
          }
        }
        ab.e("MicroMsg.SysMsgTemplateImp", "hy: invalid! should not get here");
        break label307;
        localObject1 = concactSpannable(localArrayList2);
        ab.v("MicroMsg.SysMsgTemplateImp", "hy: concatedvalue is %s", new Object[] { localObject1 });
        localArrayList1.add(localObject1);
        break;
        label868:
        if (localArrayList1.size() == 0)
        {
          ab.w("MicroMsg.SysMsgTemplateImp", "hy: not handled");
          paramMap = new SpannableString("");
          AppMethodBeat.o(136932);
          return paramMap;
        }
        paramMap = concactSpannable(localArrayList1);
        AppMethodBeat.o(136932);
        return paramMap;
      }
    }
  }
  
  private static CharSequence concactSpannable(ArrayList<CharSequence> paramArrayList)
  {
    AppMethodBeat.i(136935);
    SpannableString localSpannableString = new SpannableString("");
    Iterator localIterator = paramArrayList.iterator();
    for (paramArrayList = localSpannableString; localIterator.hasNext(); paramArrayList = TextUtils.concat(new CharSequence[] { paramArrayList, (CharSequence)localIterator.next() })) {}
    AppMethodBeat.o(136935);
    return paramArrayList;
  }
  
  private static CharSequence nullAsNil(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(136933);
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      paramCharSequence = new SpannableString("");
      AppMethodBeat.o(136933);
      return paramCharSequence;
    }
    AppMethodBeat.o(136933);
    return paramCharSequence;
  }
  
  private static CharSequence s(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(136936);
    if (bo.getInt((String)paramMap.get(paramString + ".$hidden"), 0) == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      ab.v("MicroMsg.SysMsgTemplateImp", "hy: hide");
      paramString = new SpannableString("");
      AppMethodBeat.o(136936);
      return paramString;
    }
    paramString = (String)paramMap.get(paramString + ".plain");
    paramString = new SpannableString(j.b(ah.getContext(), bo.nullAsNil(paramString)));
    AppMethodBeat.o(136936);
    return paramString;
  }
  
  public final void SM(String paramString)
  {
    AppMethodBeat.i(136927);
    ab.i("MicroMsg.SysMsgTemplateImp", "hy: removing template listener: %s", new Object[] { paramString });
    if (!this.oEa.containsKey(paramString)) {
      ab.w("MicroMsg.SysMsgTemplateImp", "[removeTemplateListener] mHandleListener is not contains this linkName:%s", new Object[] { paramString });
    }
    LinkedList localLinkedList = (LinkedList)this.oEa.get(paramString);
    if (localLinkedList == null)
    {
      ab.e("MicroMsg.SysMsgTemplateImp", "list is null!");
      AppMethodBeat.o(136927);
      return;
    }
    ab.i("MicroMsg.SysMsgTemplateImp", "[removeTemplateListener] linkName(%s) list size:%s", new Object[] { paramString, Integer.valueOf(localLinkedList.size()) });
    if (localLinkedList.size() > 0) {
      localLinkedList.removeLast();
    }
    AppMethodBeat.o(136927);
  }
  
  public final void SN(String paramString)
  {
    AppMethodBeat.i(136929);
    ab.i("MicroMsg.SysMsgTemplateImp", "hy: removing digest listener: %s", new Object[] { paramString });
    if (!this.oEb.containsKey(paramString)) {
      ab.w("MicroMsg.SysMsgTemplateImp", "[removeTemplateListener] mHandleListener is not contains this linkName:%s", new Object[] { paramString });
    }
    LinkedList localLinkedList = (LinkedList)this.oEb.get(paramString);
    ab.i("MicroMsg.SysMsgTemplateImp", "[removeDigestListener] linkName(%s) list size:%s", new Object[] { paramString, Integer.valueOf(localLinkedList.size()) });
    if (localLinkedList.size() > 0) {
      localLinkedList.removeLast();
    }
    AppMethodBeat.o(136929);
  }
  
  public final CharSequence SO(String paramString)
  {
    AppMethodBeat.i(136931);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.SysMsgTemplateImp", "hy: [digest] request translate content is null!");
      AppMethodBeat.o(136931);
      return null;
    }
    paramString = br.F(paramString, "sysmsg");
    if (paramString == null)
    {
      ab.i("MicroMsg.SysMsgTemplateImp", "hy: [digest] not retrieved sysmsg from new xml!");
      AppMethodBeat.o(136931);
      return null;
    }
    String str = (String)paramString.get(".sysmsg.$type");
    if ((bo.isNullOrNil(str)) || (!"sysmsgtemplate".equals(str)))
    {
      ab.w("MicroMsg.SysMsgTemplateImp", "hy: [digest] not acceptable sysmsg: %s", new Object[] { str });
      AppMethodBeat.o(136931);
      return null;
    }
    paramString = a(paramString, null, null, 1);
    AppMethodBeat.o(136931);
    return paramString;
  }
  
  public final CharSequence a(String paramString, Bundle paramBundle, WeakReference<Context> paramWeakReference)
  {
    AppMethodBeat.i(136930);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.SysMsgTemplateImp", "hy: request translate content is null!");
      AppMethodBeat.o(136930);
      return null;
    }
    paramString = br.F(paramString, "sysmsg");
    if (paramString == null)
    {
      ab.i("MicroMsg.SysMsgTemplateImp", "hy: not retrieved sysmsg from new xml!");
      AppMethodBeat.o(136930);
      return null;
    }
    String str = (String)paramString.get(".sysmsg.$type");
    if ((bo.isNullOrNil(str)) || (!"sysmsgtemplate".equals(str)))
    {
      ab.w("MicroMsg.SysMsgTemplateImp", "hy: not acceptable sysmsg: %s", new Object[] { str });
      AppMethodBeat.o(136930);
      return null;
    }
    paramString = a(paramString, paramBundle, paramWeakReference, 0);
    AppMethodBeat.o(136930);
    return paramString;
  }
  
  public final void a(String paramString, e.a parama)
  {
    AppMethodBeat.i(136928);
    ab.i("MicroMsg.SysMsgTemplateImp", "hy: adding digest listener: %s", new Object[] { paramString });
    if (!this.oEb.containsKey(paramString)) {
      this.oEb.put(paramString, new LinkedList());
    }
    if (!((List)this.oEb.get(paramString)).contains(parama)) {
      ((LinkedList)this.oEb.get(paramString)).add(parama);
    }
    AppMethodBeat.o(136928);
  }
  
  public final void a(String paramString, e.b paramb)
  {
    AppMethodBeat.i(136926);
    ab.i("MicroMsg.SysMsgTemplateImp", "hy: adding template listener: %s", new Object[] { paramString });
    if (!this.oEa.containsKey(paramString)) {
      this.oEa.put(paramString, new LinkedList());
    }
    if (!((List)this.oEa.get(paramString)).contains(paramb)) {
      ((LinkedList)this.oEa.get(paramString)).add(paramb);
    }
    AppMethodBeat.o(136926);
  }
  
  public final void a(String paramString, e.c paramc)
  {
    AppMethodBeat.i(136924);
    al.d(new a.2(this, paramString, paramc));
    AppMethodBeat.o(136924);
  }
  
  public final void b(String paramString, e.c paramc)
  {
    AppMethodBeat.i(136925);
    al.d(new a.3(this, paramString, paramc));
    AppMethodBeat.o(136925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.b.a
 * JD-Core Version:    0.7.0.1
 */