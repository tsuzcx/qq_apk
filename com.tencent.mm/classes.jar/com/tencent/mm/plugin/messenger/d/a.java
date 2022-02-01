package com.tencent.mm.plugin.messenger.d;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.messenger.a.f.b;
import com.tencent.mm.plugin.messenger.a.f.c;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class a
  implements f
{
  private Map<String, LinkedList<f.b>> tyV;
  private Map<String, LinkedList<com.tencent.mm.plugin.messenger.a.f.a>> tyW;
  private Map<String, HashSet<f.c>> tyX;
  private com.tencent.mm.aw.a.d.a<Long, CharSequence> tyY;
  private com.tencent.mm.aw.a.d.a<Long, CharSequence> tyZ;
  public p tza;
  
  public a()
  {
    AppMethodBeat.i(90754);
    this.tyV = new HashMap();
    this.tyW = new HashMap();
    this.tyX = new HashMap();
    this.tyY = new com.tencent.mm.aw.a.d.a(200);
    this.tyZ = new com.tencent.mm.aw.a.d.a(500);
    this.tza = new p()
    {
      public final void onNewXmlReceived(String paramAnonymousString, Map<String, String> paramAnonymousMap, com.tencent.mm.al.f.a paramAnonymousa)
      {
        AppMethodBeat.i(90750);
        ad.i("MicroMsg.SysMsgTemplateImp", "hy: on new xml received: %s", new Object[] { paramAnonymousMap.toString() });
        a.a(a.this, paramAnonymousString, paramAnonymousMap, paramAnonymousa);
        AppMethodBeat.o(90750);
      }
    };
    AppMethodBeat.o(90754);
  }
  
  private static void M(CharSequence paramCharSequence)
  {
    int i = 0;
    AppMethodBeat.i(90765);
    if ((paramCharSequence != null) && (paramCharSequence.length() > 0) && ((paramCharSequence instanceof Spanned)))
    {
      paramCharSequence = (ClickableSpan[])((Spanned)paramCharSequence).getSpans(0, paramCharSequence.length(), ClickableSpan.class);
      if ((paramCharSequence != null) && (paramCharSequence.length > 0))
      {
        int j = paramCharSequence.length;
        while (i < j)
        {
          if (!(paramCharSequence[i] instanceof com.tencent.mm.ui.base.b.a))
          {
            paramCharSequence = new IllegalArgumentException("hy: actively throw Exception!!! all clickable spans must be instance of com.tencent.mm.ui.base.span.IPressableSpan!");
            AppMethodBeat.o(90765);
            throw paramCharSequence;
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(90765);
  }
  
  private CharSequence a(Map<String, String> paramMap, Bundle paramBundle, WeakReference<Context> paramWeakReference, int paramInt, WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(196724);
    ArrayList localArrayList1 = new ArrayList();
    int i = 0;
    Object localObject2 = new StringBuilder();
    Object localObject1;
    label35:
    int j;
    if (i == 0)
    {
      localObject1 = "";
      localObject1 = localObject1;
      localObject1 = ".sysmsg.sysmsgtemplate.content_template" + (String)localObject1;
      if (bt.isNullOrNil((String)paramMap.get(localObject1))) {
        break label885;
      }
      localObject2 = (String)paramMap.get((String)localObject1 + ".$type");
      if (!agS((String)localObject2))
      {
        ad.w("MicroMsg.SysMsgTemplateImp", "hy: non supported type: %s", new Object[] { localObject2 });
        localArrayList1.add(x((String)localObject1, paramMap));
      }
      if (paramBundle != null) {
        paramBundle.putString("template_type", (String)localObject2);
      }
      localObject1 = (String)paramMap.get((String)localObject1 + ".template");
      ad.v("MicroMsg.SysMsgTemplateImp", "hy: rawTemplate : %s", new Object[] { localObject1 });
      localObject1 = c.agU((String)localObject1);
      if (localObject1 != null) {
        break label293;
      }
      j = 0;
      label227:
      ad.d("MicroMsg.SysMsgTemplateImp", "hy: parsed %d models", new Object[] { Integer.valueOf(j) });
      if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0)) {
        break label303;
      }
      localArrayList1.add(new SpannableString(""));
    }
    for (;;)
    {
      i += 1;
      break;
      localObject1 = Integer.valueOf(i);
      break label35;
      label293:
      j = ((ArrayList)localObject1).size();
      break label227;
      label303:
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = ((ArrayList)localObject1).iterator();
      while (localIterator.hasNext())
      {
        c.a locala = (c.a)localIterator.next();
        if (locala.type == 0)
        {
          localArrayList2.add(new SpannableString(k.c(aj.getContext(), locala.content)));
        }
        else if (locala.type == 1)
        {
          j = 0;
          localObject2 = ".sysmsg.sysmsgtemplate.content_template" + ".link_list.link";
          localObject1 = localObject2;
          if (j != 0) {
            localObject1 = (String)localObject2 + j;
          }
          if (!bt.isNullOrNil((String)paramMap.get(localObject1)))
          {
            localObject2 = (String)paramMap.get((String)localObject1 + ".$name");
            String str;
            label572:
            boolean bool;
            if (locala.content.equals(localObject2))
            {
              str = (String)paramMap.get((String)localObject1 + ".$type");
              if (paramInt != 0) {
                break label713;
              }
              localObject2 = (List)this.tyV.get(str);
              if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
                break label647;
              }
              localObject2 = null;
              if ((agT(str)) && (localObject2 != null)) {
                break label678;
              }
              str = bt.by(str, "");
              if (localObject2 != null) {
                break label672;
              }
              bool = true;
              label602:
              ad.i("MicroMsg.SysMsgTemplateImp", "alvinluo not support link type: %s or listener == null: %b", new Object[] { str, Boolean.valueOf(bool) });
              localArrayList2.add(x((String)localObject1, paramMap));
            }
            label647:
            label672:
            label678:
            label806:
            for (;;)
            {
              j += 1;
              break;
              localObject2 = (f.b)((LinkedList)this.tyV.get(str)).getLast();
              break label572;
              bool = false;
              break label602;
              localObject1 = ((f.b)localObject2).a(paramMap, (String)localObject1, paramBundle, paramWeakReference, paramWeakReference1);
              M((CharSequence)localObject1);
              localArrayList2.add(nullAsNil((CharSequence)localObject1));
              continue;
              label713:
              if (paramInt == 1)
              {
                localObject2 = (List)this.tyW.get(str);
                if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {}
                for (localObject2 = null;; localObject2 = (com.tencent.mm.plugin.messenger.a.f.a)((LinkedList)this.tyW.get(str)).getLast())
                {
                  if ((agT(str)) && (localObject2 != null)) {
                    break label806;
                  }
                  localArrayList2.add(x((String)localObject1, paramMap));
                  break;
                }
                localArrayList2.add(bt.nullAsNil(((com.tencent.mm.plugin.messenger.a.f.a)localObject2).e(paramMap, (String)localObject1)));
              }
              else
              {
                ad.e("MicroMsg.SysMsgTemplateImp", "hy: not supported digest type");
              }
            }
          }
        }
        else
        {
          ad.e("MicroMsg.SysMsgTemplateImp", "hy: invalid! should not get here");
        }
      }
      localObject1 = concactSpannable(localArrayList2);
      ad.v("MicroMsg.SysMsgTemplateImp", "hy: concatedvalue is %s", new Object[] { localObject1 });
      localArrayList1.add(localObject1);
    }
    label885:
    if (localArrayList1.size() == 0)
    {
      ad.w("MicroMsg.SysMsgTemplateImp", "hy: not handled");
      paramMap = new SpannableString("");
      AppMethodBeat.o(196724);
      return paramMap;
    }
    paramMap = concactSpannable(localArrayList1);
    AppMethodBeat.o(196724);
    return paramMap;
  }
  
  private static boolean agS(String paramString)
  {
    AppMethodBeat.i(90768);
    if (("tmpl_type_profile".equals(paramString)) || ("tmpl_type_profilewithrevoke".equals(paramString)) || ("tmpl_type_profilewithrevokeqrcode".equals(paramString)) || ("tmpl_type_wxappnotifywithview".equals(paramString)) || ("tmpl_type_succeed_contact".equals(paramString)) || ("tmpl_type_jump_chat".equals(paramString)) || ("new_tmpl_type_succeed_contact".equals(paramString)))
    {
      AppMethodBeat.o(90768);
      return true;
    }
    AppMethodBeat.o(90768);
    return false;
  }
  
  private static boolean agT(String paramString)
  {
    AppMethodBeat.i(90769);
    if (("link_profile".equals(paramString)) || ("link_revoke".equals(paramString)) || ("link_revoke_qrcode".equals(paramString)) || ("link_plain".equals(paramString)) || ("link_view_wxapp".equals(paramString)) || ("link_succeed_contact".equals(paramString)) || ("link_jump_chat".equals(paramString)) || ("link_admin_explain".equals(paramString)) || ("link_live".equals(paramString)) || ("comment_link_profile".equals(paramString)) || ("new_link_succeed_contact".equals(paramString)))
    {
      AppMethodBeat.o(90769);
      return true;
    }
    AppMethodBeat.o(90769);
    return false;
  }
  
  private static CharSequence concactSpannable(ArrayList<CharSequence> paramArrayList)
  {
    AppMethodBeat.i(90766);
    SpannableString localSpannableString = new SpannableString("");
    Iterator localIterator = paramArrayList.iterator();
    for (paramArrayList = localSpannableString; localIterator.hasNext(); paramArrayList = TextUtils.concat(new CharSequence[] { paramArrayList, (CharSequence)localIterator.next() })) {}
    AppMethodBeat.o(90766);
    return paramArrayList;
  }
  
  private static CharSequence nullAsNil(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(90764);
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
    {
      paramCharSequence = new SpannableString("");
      AppMethodBeat.o(90764);
      return paramCharSequence;
    }
    AppMethodBeat.o(90764);
    return paramCharSequence;
  }
  
  private static CharSequence x(String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(90767);
    if (bt.getInt((String)paramMap.get(paramString + ".$hidden"), 0) == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      ad.v("MicroMsg.SysMsgTemplateImp", "hy: hide");
      paramString = new SpannableString("");
      AppMethodBeat.o(90767);
      return paramString;
    }
    paramString = (String)paramMap.get(paramString + ".plain");
    paramString = new SpannableString(k.c(aj.getContext(), bt.nullAsNil(paramString)));
    AppMethodBeat.o(90767);
    return paramString;
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.messenger.a.f.a parama)
  {
    AppMethodBeat.i(90759);
    ad.i("MicroMsg.SysMsgTemplateImp", "hy: adding digest listener: %s", new Object[] { paramString });
    if (!this.tyW.containsKey(paramString)) {
      this.tyW.put(paramString, new LinkedList());
    }
    if (!((List)this.tyW.get(paramString)).contains(parama)) {
      ((LinkedList)this.tyW.get(paramString)).add(parama);
    }
    AppMethodBeat.o(90759);
  }
  
  public final void a(String paramString, f.b paramb)
  {
    AppMethodBeat.i(196720);
    if (!this.tyV.containsKey(paramString)) {
      this.tyV.put(paramString, new LinkedList());
    }
    List localList = (List)this.tyV.get(paramString);
    ad.i("MicroMsg.SysMsgTemplateImp", "hy: adding template listener: %s list=%s", new Object[] { paramString, localList });
    if ((localList != null) && (!localList.contains(paramb))) {
      ((LinkedList)this.tyV.get(paramString)).add(paramb);
    }
    AppMethodBeat.o(196720);
  }
  
  public final void a(final String paramString, final f.c paramc)
  {
    AppMethodBeat.i(196718);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(90751);
        ad.i("MicroMsg.SysMsgTemplateImp", "hy: adding Received listener: %s", new Object[] { paramString });
        HashSet localHashSet2 = (HashSet)a.a(a.this).get(paramString);
        HashSet localHashSet1 = localHashSet2;
        if (localHashSet2 == null) {
          localHashSet1 = new HashSet();
        }
        if (!localHashSet1.contains(paramc)) {
          localHashSet1.add(paramc);
        }
        a.a(a.this).put(paramString, localHashSet1);
        AppMethodBeat.o(90751);
      }
    });
    AppMethodBeat.o(196718);
  }
  
  public final void a(String paramString, Map<String, String> paramMap, Bundle paramBundle)
  {
    AppMethodBeat.i(196723);
    try
    {
      Object localObject = paramBundle.getString("template_type");
      localObject = (HashSet)this.tyX.get(localObject);
      if (localObject != null)
      {
        localObject = ((HashSet)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((f.c)((Iterator)localObject).next()).b(paramString, paramMap, paramBundle);
        }
      }
      AppMethodBeat.o(196723);
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.SysMsgTemplateImp", paramString, "", new Object[0]);
      AppMethodBeat.o(196723);
      return;
    }
  }
  
  public final void afO(String paramString)
  {
    AppMethodBeat.i(196721);
    ad.i("MicroMsg.SysMsgTemplateImp", "hy: removing template listener: %s", new Object[] { paramString });
    if (!this.tyV.containsKey(paramString)) {
      ad.w("MicroMsg.SysMsgTemplateImp", "[removeTemplateListener] mHandleListener is not contains this linkName:%s", new Object[] { paramString });
    }
    LinkedList localLinkedList = (LinkedList)this.tyV.get(paramString);
    if (localLinkedList == null)
    {
      ad.e("MicroMsg.SysMsgTemplateImp", "list is null!");
      AppMethodBeat.o(196721);
      return;
    }
    ad.i("MicroMsg.SysMsgTemplateImp", "[removeTemplateListener] linkName(%s) list size:%s", new Object[] { paramString, Integer.valueOf(localLinkedList.size()) });
    if (localLinkedList.size() > 0) {
      localLinkedList.removeLast();
    }
    AppMethodBeat.o(196721);
  }
  
  public final void afP(String paramString)
  {
    AppMethodBeat.i(90760);
    ad.i("MicroMsg.SysMsgTemplateImp", "hy: removing digest listener: %s", new Object[] { paramString });
    if (!this.tyW.containsKey(paramString)) {
      ad.w("MicroMsg.SysMsgTemplateImp", "[removeTemplateListener] mHandleListener is not contains this linkName:%s", new Object[] { paramString });
    }
    LinkedList localLinkedList = (LinkedList)this.tyW.get(paramString);
    ad.i("MicroMsg.SysMsgTemplateImp", "[removeDigestListener] linkName(%s) list size:%s", new Object[] { paramString, Integer.valueOf(localLinkedList.size()) });
    if (localLinkedList.size() > 0) {
      localLinkedList.removeLast();
    }
    AppMethodBeat.o(90760);
  }
  
  public final CharSequence afQ(String paramString)
  {
    AppMethodBeat.i(90762);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.SysMsgTemplateImp", "hy: [digest] request translate content is null!");
      AppMethodBeat.o(90762);
      return null;
    }
    paramString = bw.K(paramString, "sysmsg");
    if (paramString == null)
    {
      ad.i("MicroMsg.SysMsgTemplateImp", "hy: [digest] not retrieved sysmsg from new xml!");
      AppMethodBeat.o(90762);
      return null;
    }
    String str = (String)paramString.get(".sysmsg.$type");
    if ((bt.isNullOrNil(str)) || (!"sysmsgtemplate".equals(str)))
    {
      ad.w("MicroMsg.SysMsgTemplateImp", "hy: [digest] not acceptable sysmsg: %s", new Object[] { str });
      AppMethodBeat.o(90762);
      return null;
    }
    paramString = a(paramString, null, null, 1, null);
    AppMethodBeat.o(90762);
    return paramString;
  }
  
  public final CharSequence b(String paramString, Bundle paramBundle, WeakReference<Context> paramWeakReference, WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(196722);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.SysMsgTemplateImp", "hy: request translate content is null!");
      AppMethodBeat.o(196722);
      return null;
    }
    paramString = bw.K(paramString, "sysmsg");
    if (paramString == null)
    {
      ad.i("MicroMsg.SysMsgTemplateImp", "hy: not retrieved sysmsg from new xml!");
      AppMethodBeat.o(196722);
      return null;
    }
    String str = (String)paramString.get(".sysmsg.$type");
    if ((bt.isNullOrNil(str)) || (!"sysmsgtemplate".equals(str)))
    {
      ad.w("MicroMsg.SysMsgTemplateImp", "hy: not acceptable sysmsg: %s", new Object[] { str });
      AppMethodBeat.o(196722);
      return null;
    }
    paramString = a(paramString, paramBundle, paramWeakReference, 0, paramWeakReference1);
    AppMethodBeat.o(196722);
    return paramString;
  }
  
  public final void b(final String paramString, final f.c paramc)
  {
    AppMethodBeat.i(196719);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(90752);
        ad.i("MicroMsg.SysMsgTemplateImp", "hy: removing Received listener: %s", new Object[] { paramString });
        HashSet localHashSet = (HashSet)a.a(a.this).get(paramString);
        if (localHashSet == null)
        {
          AppMethodBeat.o(90752);
          return;
        }
        localHashSet.remove(paramc);
        if (localHashSet.size() == 0)
        {
          a.a(a.this).remove(paramString);
          AppMethodBeat.o(90752);
          return;
        }
        a.a(a.this).put(paramString, localHashSet);
        AppMethodBeat.o(90752);
      }
    });
    AppMethodBeat.o(196719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.d.a
 * JD-Core Version:    0.7.0.1
 */