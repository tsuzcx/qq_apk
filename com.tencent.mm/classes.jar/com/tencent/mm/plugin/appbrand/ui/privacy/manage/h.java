package com.tencent.mm.plugin.appbrand.ui.privacy.manage;

import android.content.Context;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.protocal.protobuf.gng;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/manage/UserAuthorizeScopeListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/manage/AuthorizeScopeListViewHolder;", "()V", "userAuthScopeList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/manage/WxaAppAuthorizeScopeListWithAttrs;", "Lkotlin/collections/ArrayList;", "username2AuthScopeInfoMap", "Ljava/util/HashMap;", "", "Lkotlin/Pair;", "", "Lkotlin/collections/HashMap;", "appendFetchedUserAuthorizeScopeList", "", "fetchedUserAuthScopeList", "", "concatContent", "suffixFormat", "splitter", "wordings", "", "indexLimit", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;I)Ljava/lang/String;", "getFetchedAuthorizeScopeInfo", "position", "username", "getItemCount", "getItemId", "", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onUserAuthorizeScopeChanged", "authScopeInfo", "sniffAuthInfoContent", "textView", "Landroid/widget/TextView;", "(Landroid/widget/TextView;[Ljava/lang/String;)Ljava/lang/String;", "testGuess", "", "paint", "Landroid/text/TextPaint;", "lineWidth", "guess", "contentHolder", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/manage/UserAuthorizeScopeListAdapter$StringHolder;", "(Landroid/text/TextPaint;ILjava/lang/String;Ljava/lang/String;[Ljava/lang/String;ILcom/tencent/mm/plugin/appbrand/ui/privacy/manage/UserAuthorizeScopeListAdapter$StringHolder;)Z", "StringHolder", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class h
  extends RecyclerView.a<f>
{
  final ArrayList<j> ujq;
  final HashMap<String, r<j, Integer>> ujr;
  
  public h()
  {
    AppMethodBeat.i(323001);
    this.ujq = new ArrayList();
    this.ujr = new HashMap();
    AppMethodBeat.o(323001);
  }
  
  private static String a(TextView paramTextView, String[] paramArrayOfString)
  {
    AppMethodBeat.i(323013);
    if (paramArrayOfString.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramTextView = paramTextView.getContext().getString(ba.i.appbrand_privacy_manage_auth_empty_info);
      AppMethodBeat.o(323013);
      return paramTextView;
    }
    TextPaint localTextPaint = paramTextView.getPaint();
    int i1 = paramTextView.getWidth();
    int i2 = paramTextView.getPaddingLeft();
    int i3 = paramTextView.getPaddingRight();
    String str1 = paramTextView.getContext().getString(ba.i.appbrand_privacy_manage_auth_info_suffix_format);
    s.s(str1, "textView.context.getStri…_auth_info_suffix_format)");
    String str2 = paramTextView.getContext().getString(ba.i.appbrand_privacy_manage_auth_info_splitter);
    s.s(str2, "textView.context.getStri…anage_auth_info_splitter)");
    h.a locala = new h.a((byte)0);
    i = 0;
    int i4 = paramArrayOfString.length - 1;
    int m;
    int j;
    label161:
    int k;
    label168:
    int n;
    if (i4 >= 0)
    {
      paramTextView = null;
      m = i + 1;
      s.s(localTextPaint, "paint");
      Object localObject = new StringBuilder();
      int i5 = paramArrayOfString.length;
      if (i5 - 1 != i)
      {
        j = 1;
        k = 0;
        if (i > 0)
        {
          n = k + 1;
          ((StringBuilder)localObject).append(paramArrayOfString[k]);
          ((StringBuilder)localObject).append(str2);
          if (n < i) {
            break label375;
          }
        }
        ((StringBuilder)localObject).append(paramArrayOfString[i]);
        if (j != 0)
        {
          String str3 = String.format(str1, Arrays.copyOf(new Object[] { Integer.valueOf(i5 - 1 - i) }, 1));
          s.s(str3, "java.lang.String.format(this, *args)");
          ((StringBuilder)localObject).append(str3);
        }
        localObject = ((StringBuilder)localObject).toString();
        s.s(localObject, "StringBuilder().apply(builderAction).toString()");
        locala.value = ((String)localObject);
        if (new StaticLayout((CharSequence)localObject, localTextPaint, i1 - i2 - i3, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineCount() > 1) {
          break label354;
        }
        i = 1;
        label311:
        if (i == 0) {
          break label372;
        }
        paramTextView = locala.value;
        s.checkNotNull(paramTextView);
        if (m <= i4) {
          break label366;
        }
      }
    }
    for (;;)
    {
      if (paramTextView == null)
      {
        paramTextView = locala.value;
        AppMethodBeat.o(323013);
        return paramTextView;
        j = 0;
        break label161;
        label354:
        i = 0;
        break label311;
      }
      AppMethodBeat.o(323013);
      return paramTextView;
      label366:
      i = m;
      break;
      label372:
      continue;
      label375:
      k = n;
      break label168;
      paramTextView = null;
    }
  }
  
  private static final void a(f paramf, h paramh, j paramj)
  {
    AppMethodBeat.i(323025);
    s.u(paramf, "$holder");
    s.u(paramh, "this$0");
    s.u(paramj, "$authScopeInfo");
    paramh = paramf.ujl;
    paramf = paramf.ujl;
    Object localObject = (Iterable)paramj.uju;
    paramj = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramj.add(((gng)((Iterator)localObject).next()).desc);
    }
    paramj = ((Collection)paramj).toArray(new String[0]);
    if (paramj == null)
    {
      paramf = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(323025);
      throw paramf;
    }
    paramh.setText((CharSequence)a(paramf, (String[])paramj));
    AppMethodBeat.o(323025);
  }
  
  public final void dH(List<j> paramList)
  {
    AppMethodBeat.i(323038);
    s.u(paramList, "fetchedUserAuthScopeList");
    int j = this.ujq.size();
    int k = paramList.size();
    Log.i("MicroMsg.AppBrandPrivacyManagePage", "appendFetchedUserAuthorizeScopeList, posInsert: " + j + ", insertCount: " + k);
    this.ujq.addAll((Collection)paramList);
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (i < 0) {
        p.kkW();
      }
      localObject = (j)localObject;
      Map localMap = (Map)this.ujr;
      String str = ((j)localObject).ujt.field_username;
      s.s(str, "authScopeInfo.wxaAttrs.field_username");
      localMap.put(str, v.Y(localObject, Integer.valueOf(i + j)));
      i += 1;
    }
    bA(j, k);
    AppMethodBeat.o(323038);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(323048);
    int i = this.ujq.size();
    AppMethodBeat.o(323048);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.manage.h
 * JD-Core Version:    0.7.0.1
 */