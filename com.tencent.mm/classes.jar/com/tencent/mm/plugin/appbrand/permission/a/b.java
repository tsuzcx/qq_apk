package com.tencent.mm.plugin.appbrand.permission.a;

import android.view.MotionEvent;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.permission.h;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.d;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePromptPresenterView;", "appBrandName", "", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "applyWording", "getApplyWording", "setApplyWording", "iconUrl", "getIconUrl", "setIconUrl", "itemCheckedListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "getItemCheckedListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "setItemCheckedListener", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;)V", "requestDesc", "getRequestDesc", "setRequestDesc", "simpleDetailDesc", "getSimpleDetailDesc", "setSimpleDetailDesc", "getLastPointerDownTouchEvent", "Landroid/view/MotionEvent;", "setExplainOnClickListener", "", "listener", "Landroid/view/View$OnClickListener;", "setFunctionButtonOnClickListener", "setFunctionButtonText", "text", "setFunctionButtonTextColor", "color", "", "setFunctionButtonVisibility", "visibility", "setNegativeButtonText", "negativeButtonText", "setOnListItemLongClickListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "setPositiveButtonText", "positiveButtonText", "setScope", "scope", "setSelectListItem", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "showExplainIv", "show", "", "Factory", "FactoryInterface", "Listener", "ResultCodeEnum", "luggage-wechat-full-sdk_release"})
public abstract interface b
  extends h
{
  public static final b.d nyx = b.d.nyA;
  
  public abstract MotionEvent getLastPointerDownTouchEvent();
  
  public abstract void ia(boolean paramBoolean);
  
  public abstract void setAppBrandName(String paramString);
  
  public abstract void setApplyWording(String paramString);
  
  public abstract void setExplainOnClickListener(View.OnClickListener paramOnClickListener);
  
  public abstract void setFunctionButtonOnClickListener(View.OnClickListener paramOnClickListener);
  
  public abstract void setFunctionButtonText(String paramString);
  
  public abstract void setFunctionButtonTextColor(int paramInt);
  
  public abstract void setFunctionButtonVisibility(int paramInt);
  
  public abstract void setIconUrl(String paramString);
  
  public abstract void setItemCheckedListener(i.b paramb);
  
  public abstract void setNegativeButtonText(String paramString);
  
  public abstract void setOnListItemLongClickListener(i.d paramd);
  
  public abstract void setPositiveButtonText(String paramString);
  
  public abstract void setRequestDesc(String paramString);
  
  public abstract void setScope(String paramString);
  
  public abstract void setSelectListItem(List<i.a> paramList);
  
  public abstract void setSimpleDetailDesc(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.a.b
 * JD-Core Version:    0.7.0.1
 */