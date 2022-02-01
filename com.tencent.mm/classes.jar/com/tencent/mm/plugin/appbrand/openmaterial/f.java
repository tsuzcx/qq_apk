package com.tencent.mm.plugin.appbrand.openmaterial;

import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialModel;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"ELLIPSIS_NORMAL", "", "GROUP_ID_OPEN_MATERIAL", "", "MAX_MENU_ITEM_COUNT", "TAG", "getFirstLineEndPos", "textPaint", "Landroid/text/TextPaint;", "text", "", "lineWidth", "getRawFunctionName2Show", "Lcom/tencent/mm/plugin/appbrand/openmaterial/RawFunctionName2Show;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialModel;", "setText", "", "Landroid/widget/TextView;", "rawFunctionName2Show", "plugin-appbrand-integration_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class f
{
  static final m a(AppBrandOpenMaterialModel paramAppBrandOpenMaterialModel)
  {
    AppMethodBeat.i(323551);
    String str = paramAppBrandOpenMaterialModel.appName;
    Object localObject = (CharSequence)str;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramAppBrandOpenMaterialModel = paramAppBrandOpenMaterialModel.trR;
      s.s(paramAppBrandOpenMaterialModel, "functionName");
      paramAppBrandOpenMaterialModel = new m(paramAppBrandOpenMaterialModel, null, 6);
      AppMethodBeat.o(323551);
      return paramAppBrandOpenMaterialModel;
    }
    localObject = paramAppBrandOpenMaterialModel.trR;
    s.s(localObject, "functionName");
    i = n.a((CharSequence)localObject, str, 0, false, 6);
    if (-1 == i)
    {
      paramAppBrandOpenMaterialModel = paramAppBrandOpenMaterialModel.trR;
      s.s(paramAppBrandOpenMaterialModel, "functionName");
      paramAppBrandOpenMaterialModel = new m(paramAppBrandOpenMaterialModel, null, 6);
      AppMethodBeat.o(323551);
      return paramAppBrandOpenMaterialModel;
    }
    int j = i + str.length();
    if (j == paramAppBrandOpenMaterialModel.trR.length())
    {
      if (i != 0)
      {
        paramAppBrandOpenMaterialModel = paramAppBrandOpenMaterialModel.trR;
        s.s(paramAppBrandOpenMaterialModel, "functionName");
        paramAppBrandOpenMaterialModel = paramAppBrandOpenMaterialModel.substring(0, i);
        s.s(paramAppBrandOpenMaterialModel, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        paramAppBrandOpenMaterialModel = new m(paramAppBrandOpenMaterialModel, str, 4);
        AppMethodBeat.o(323551);
        return paramAppBrandOpenMaterialModel;
      }
    }
    else
    {
      str = paramAppBrandOpenMaterialModel.trR;
      s.s(str, "functionName");
      str = str.substring(0, j);
      s.s(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      paramAppBrandOpenMaterialModel = paramAppBrandOpenMaterialModel.trR;
      s.s(paramAppBrandOpenMaterialModel, "functionName");
      paramAppBrandOpenMaterialModel = paramAppBrandOpenMaterialModel.substring(j);
      s.s(paramAppBrandOpenMaterialModel, "(this as java.lang.String).substring(startIndex)");
      paramAppBrandOpenMaterialModel = new m(str, paramAppBrandOpenMaterialModel, true);
      AppMethodBeat.o(323551);
      return paramAppBrandOpenMaterialModel;
    }
    paramAppBrandOpenMaterialModel = paramAppBrandOpenMaterialModel.trR;
    s.s(paramAppBrandOpenMaterialModel, "functionName");
    paramAppBrandOpenMaterialModel = new m(paramAppBrandOpenMaterialModel, null, 6);
    AppMethodBeat.o(323551);
    return paramAppBrandOpenMaterialModel;
  }
  
  static final void a(TextView paramTextView, m paramm)
  {
    AppMethodBeat.i(323555);
    if (!paramm.trD)
    {
      paramTextView.setText((CharSequence)paramm.trE);
      AppMethodBeat.o(323555);
      return;
    }
    paramTextView.post(new f..ExternalSyntheticLambda0(paramTextView, paramm));
    AppMethodBeat.o(323555);
  }
  
  private static final void b(TextView paramTextView, m paramm)
  {
    int i = 1;
    AppMethodBeat.i(323562);
    s.u(paramTextView, "$this_setText");
    s.u(paramm, "$rawFunctionName2Show");
    int j = paramTextView.getWidth() - paramTextView.getPaddingLeft() - paramTextView.getPaddingRight();
    Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", s.X("setText, lineWidth: ", Integer.valueOf(j)));
    Object localObject = paramTextView.getPaint();
    s.s(localObject, "paint");
    localObject = new StaticLayout((CharSequence)paramm.trB, (TextPaint)localObject, j, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
    if (((StaticLayout)localObject).getLineCount() <= 0)
    {
      Log.w("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "getFirstLineEndPos, lineCount(" + ((StaticLayout)localObject).getLineCount() + ") is illegal");
      j = 0;
      Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", s.X("setText, firstLineEndPos: ", Integer.valueOf(j)));
      if (j <= 0) {
        break label191;
      }
      if (j > paramm.trB.length()) {
        break label186;
      }
    }
    for (;;)
    {
      if (i != 0) {
        break label196;
      }
      paramTextView.setText((CharSequence)paramm.trE);
      AppMethodBeat.o(323562);
      return;
      j = ((StaticLayout)localObject).getLineEnd(0);
      break;
      label186:
      i = 0;
      continue;
      label191:
      i = 0;
    }
    label196:
    if (j == paramm.trB.length()) {}
    for (localObject = paramm.trB;; localObject = s.X((String)localObject, "…"))
    {
      paramm = (String)localObject + '\n' + paramm.trC;
      Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", s.X("setText, functionName2Show: ", paramm));
      paramTextView.setText((CharSequence)paramm);
      AppMethodBeat.o(323562);
      return;
      localObject = paramm.trB;
      if (localObject == null)
      {
        paramTextView = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(323562);
        throw paramTextView;
      }
      localObject = ((String)localObject).substring(0, j - 1);
      s.s(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.f
 * JD-Core Version:    0.7.0.1
 */