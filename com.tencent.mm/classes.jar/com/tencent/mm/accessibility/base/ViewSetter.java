package com.tencent.mm.accessibility.base;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.type.IdType;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.accessibility.uitl.IdUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/base/ViewSetter;", "Lcom/tencent/mm/accessibility/base/Confirmable;", "ownerConfig", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "rootId", "", "viewId", "(Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;II)V", "backwardCallback", "Lkotlin/Function1;", "Landroid/view/View;", "", "getBackwardCallback$plugin_autoaccessibility_release", "()Lkotlin/jvm/functions/Function1;", "setBackwardCallback$plugin_autoaccessibility_release", "(Lkotlin/jvm/functions/Function1;)V", "contentRes", "getContentRes$plugin_autoaccessibility_release", "()Ljava/lang/Integer;", "setContentRes$plugin_autoaccessibility_release", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "contentResType", "", "getContentResType$plugin_autoaccessibility_release", "()Ljava/lang/String;", "setContentResType$plugin_autoaccessibility_release", "(Ljava/lang/String;)V", "descCallback", "getDescCallback$plugin_autoaccessibility_release", "setDescCallback$plugin_autoaccessibility_release", "disable", "", "getDisable$plugin_autoaccessibility_release", "()Z", "setDisable$plugin_autoaccessibility_release", "(Z)V", "disableChild", "getDisableChild$plugin_autoaccessibility_release", "setDisableChild$plugin_autoaccessibility_release", "forwardCallback", "getForwardCallback$plugin_autoaccessibility_release", "setForwardCallback$plugin_autoaccessibility_release", "placeHolderValueList", "", "", "getRootId$plugin_autoaccessibility_release", "()I", "type", "Lcom/tencent/mm/accessibility/type/ViewType;", "getType$plugin_autoaccessibility_release", "()Lcom/tencent/mm/accessibility/type/ViewType;", "setType$plugin_autoaccessibility_release", "(Lcom/tencent/mm/accessibility/type/ViewType;)V", "getViewId$plugin_autoaccessibility_release", "checkOn", "check", "condition", "checkValue", "clickAs", "targetId", "confirm", "confirm$plugin_autoaccessibility_release", "desc", "callback", "id", "descFormat", "disExpand", "disableChildren", "expand", "left", "top", "right", "bottom", "onSeekBackward", "onSeekForward", "setContentDesc", "stringRes", "setContentDesc$plugin_autoaccessibility_release", "setContentDescByAnotherView", "idRes", "setContentDescByAnotherView$plugin_autoaccessibility_release", "talkOn", "function", "valueByKey", "key", "valueByString", "valueByView", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ViewSetter
  extends Confirmable
{
  private b<? super View, ah> backwardCallback;
  private Integer contentRes;
  private String contentResType;
  private b<? super View, String> descCallback;
  private boolean disable;
  private boolean disableChild;
  private b<? super View, ah> forwardCallback;
  private final MMBaseAccessibilityConfig ownerConfig;
  private final List<Object> placeHolderValueList;
  private final int rootId;
  private ViewType type;
  private final int viewId;
  
  public ViewSetter(MMBaseAccessibilityConfig paramMMBaseAccessibilityConfig, int paramInt1, int paramInt2)
  {
    super(paramMMBaseAccessibilityConfig);
    AppMethodBeat.i(234409);
    this.ownerConfig = paramMMBaseAccessibilityConfig;
    this.rootId = paramInt1;
    this.viewId = paramInt2;
    this.placeHolderValueList = ((List)new ArrayList());
    AppMethodBeat.o(234409);
  }
  
  private final void checkValue()
  {
    AppMethodBeat.i(234418);
    if (this.contentRes == null)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("check layoutId,id must not be null and must set contentDesc res");
      AppMethodBeat.o(234418);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(234418);
  }
  
  public final ViewSetter checkOn(b<? super View, Boolean> paramb)
  {
    AppMethodBeat.i(234489);
    s.u(paramb, "check");
    ((ViewSetter)this).checkOn(paramb, (b)ViewSetter.checkOn.1.1.INSTANCE);
    paramb = (ViewSetter)this;
    AppMethodBeat.o(234489);
    return paramb;
  }
  
  public final ViewSetter checkOn(b<? super View, Boolean> paramb1, b<? super View, Boolean> paramb2)
  {
    AppMethodBeat.i(234494);
    s.u(paramb1, "check");
    s.u(paramb2, "condition");
    ViewSetter localViewSetter = (ViewSetter)this;
    MapExpandKt.putData(localViewSetter.ownerConfig.getViewRootCheckedMap$plugin_autoaccessibility_release(), localViewSetter.getViewId$plugin_autoaccessibility_release(), localViewSetter.getRootId$plugin_autoaccessibility_release(), new r(paramb1, paramb2));
    paramb1 = (ViewSetter)this;
    AppMethodBeat.o(234494);
    return paramb1;
  }
  
  public final ViewSetter clickAs(int paramInt)
  {
    AppMethodBeat.i(234480);
    ((ViewSetter)this).clickAs(paramInt, (b)ViewSetter.clickAs.1.1.INSTANCE);
    ViewSetter localViewSetter = (ViewSetter)this;
    AppMethodBeat.o(234480);
    return localViewSetter;
  }
  
  public final ViewSetter clickAs(int paramInt, b<? super View, Boolean> paramb)
  {
    AppMethodBeat.i(234485);
    s.u(paramb, "condition");
    ViewSetter localViewSetter = (ViewSetter)this;
    MapExpandKt.putData(localViewSetter.ownerConfig.getClickViewRootTargetMap$plugin_autoaccessibility_release(), localViewSetter.getViewId$plugin_autoaccessibility_release(), localViewSetter.getRootId$plugin_autoaccessibility_release(), new r(Integer.valueOf(paramInt), paramb));
    paramb = (ViewSetter)this;
    AppMethodBeat.o(234485);
    return paramb;
  }
  
  public final void confirm$plugin_autoaccessibility_release()
  {
    AppMethodBeat.i(234450);
    Object localObject2;
    if ((this.contentRes != null) && (this.contentResType != null))
    {
      localObject1 = (List)new ArrayList();
      localObject2 = getContentResType$plugin_autoaccessibility_release();
      s.checkNotNull(localObject2);
      ((List)localObject1).add(localObject2);
      localObject2 = getContentRes$plugin_autoaccessibility_release();
      s.checkNotNull(localObject2);
      ((List)localObject1).add(localObject2);
      ((List)localObject1).addAll((Collection)this.placeHolderValueList);
      MapExpandKt.putData(this.ownerConfig.getViewRootDescMap$plugin_autoaccessibility_release(), this.viewId, this.rootId, localObject1);
    }
    int i;
    List localList;
    if (this.disable)
    {
      localObject1 = (List)this.ownerConfig.getDisFocusViewRootMap$plugin_autoaccessibility_release().get(Integer.valueOf(this.viewId));
      if (localObject1 != null) {
        break label385;
      }
      localObject1 = null;
      if (localObject1 == null)
      {
        localObject1 = (ViewSetter)this;
        localObject2 = ((ViewSetter)localObject1).ownerConfig.getDisFocusViewRootMap$plugin_autoaccessibility_release();
        i = ((ViewSetter)localObject1).getViewId$plugin_autoaccessibility_release();
        localList = (List)new ArrayList();
        localList.add(Integer.valueOf(((ViewSetter)localObject1).getRootId$plugin_autoaccessibility_release()));
        ((Map)localObject2).put(Integer.valueOf(i), localList);
      }
    }
    Object localObject1 = this.descCallback;
    if (localObject1 != null) {
      this.ownerConfig.addCallback$plugin_autoaccessibility_release(getRootId$plugin_autoaccessibility_release(), getViewId$plugin_autoaccessibility_release(), (b)localObject1);
    }
    localObject1 = this.type;
    if (localObject1 != null) {
      MapExpandKt.putData(this.ownerConfig.getTypeMap$plugin_autoaccessibility_release(), getViewId$plugin_autoaccessibility_release(), getRootId$plugin_autoaccessibility_release(), localObject1);
    }
    if (this.disableChild)
    {
      localObject1 = (List)this.ownerConfig.getDisableChildViewRootMap$plugin_autoaccessibility_release().get(Integer.valueOf(this.viewId));
      if (localObject1 != null) {
        break label405;
      }
    }
    label385:
    label405:
    for (localObject1 = null;; localObject1 = Boolean.valueOf(((List)localObject1).add(Integer.valueOf(this.rootId))))
    {
      if (localObject1 == null)
      {
        localObject1 = (ViewSetter)this;
        localObject2 = ((ViewSetter)localObject1).ownerConfig.getDisableChildViewRootMap$plugin_autoaccessibility_release();
        i = ((ViewSetter)localObject1).getViewId$plugin_autoaccessibility_release();
        localList = (List)new ArrayList();
        localList.add(Integer.valueOf(((ViewSetter)localObject1).getRootId$plugin_autoaccessibility_release()));
        ((Map)localObject2).put(Integer.valueOf(i), localList);
      }
      MapExpandKt.putData(this.ownerConfig.getViewRootSeekCallback$plugin_autoaccessibility_release(), this.viewId, this.rootId, new r(this.forwardCallback, this.backwardCallback));
      AppMethodBeat.o(234450);
      return;
      localObject1 = Boolean.valueOf(((List)localObject1).add(Integer.valueOf(this.rootId)));
      break;
    }
  }
  
  public final ViewSetter desc(int paramInt)
  {
    AppMethodBeat.i(234452);
    ViewSetter localViewSetter = (ViewSetter)this;
    IdType localIdType = IdUtil.INSTANCE.getType(paramInt);
    switch (WhenMappings.$EnumSwitchMapping$0[localIdType.ordinal()])
    {
    }
    for (;;)
    {
      localViewSetter = (ViewSetter)this;
      AppMethodBeat.o(234452);
      return localViewSetter;
      localViewSetter.setContentDescByAnotherView$plugin_autoaccessibility_release(paramInt);
      continue;
      localViewSetter.setContentDesc$plugin_autoaccessibility_release(paramInt);
    }
  }
  
  public final ViewSetter desc(b<? super View, String> paramb)
  {
    AppMethodBeat.i(234454);
    s.u(paramb, "callback");
    ((ViewSetter)this).setDescCallback$plugin_autoaccessibility_release(paramb);
    paramb = (ViewSetter)this;
    AppMethodBeat.o(234454);
    return paramb;
  }
  
  public final ViewSetter descFormat(int paramInt)
  {
    AppMethodBeat.i(234453);
    ((ViewSetter)this).setContentDesc$plugin_autoaccessibility_release(paramInt);
    ViewSetter localViewSetter = (ViewSetter)this;
    AppMethodBeat.o(234453);
    return localViewSetter;
  }
  
  public final ViewSetter disExpand()
  {
    AppMethodBeat.i(234473);
    ViewSetter localViewSetter = (ViewSetter)this;
    Map localMap = localViewSetter.ownerConfig.getViewRootDisableExpandList$plugin_autoaccessibility_release();
    Integer localInteger = Integer.valueOf(localViewSetter.getViewId$plugin_autoaccessibility_release());
    Object localObject2 = localMap.get(localInteger);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = (List)new ArrayList();
      localMap.put(localInteger, localObject1);
    }
    ((List)localObject1).add(Integer.valueOf(localViewSetter.getRootId$plugin_autoaccessibility_release()));
    localObject1 = (ViewSetter)this;
    AppMethodBeat.o(234473);
    return localObject1;
  }
  
  public final ViewSetter disable()
  {
    AppMethodBeat.i(234462);
    ((ViewSetter)this).setDisable$plugin_autoaccessibility_release(true);
    ViewSetter localViewSetter = (ViewSetter)this;
    AppMethodBeat.o(234462);
    return localViewSetter;
  }
  
  public final ViewSetter disableChild()
  {
    AppMethodBeat.i(234476);
    ((ViewSetter)this).setDisableChild$plugin_autoaccessibility_release(true);
    ViewSetter localViewSetter = (ViewSetter)this;
    AppMethodBeat.o(234476);
    return localViewSetter;
  }
  
  public final ViewSetter disableChildren()
  {
    AppMethodBeat.i(234478);
    ((ViewSetter)this).setDisableChild$plugin_autoaccessibility_release(true);
    ViewSetter localViewSetter = (ViewSetter)this;
    AppMethodBeat.o(234478);
    return localViewSetter;
  }
  
  public final ViewSetter expand(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(234470);
    ViewSetter localViewSetter = (ViewSetter)this;
    paramInt1 = Math.max(paramInt1, 0);
    paramInt2 = Math.max(paramInt2, 0);
    paramInt3 = Math.max(paramInt3, 0);
    paramInt4 = Math.max(paramInt4, 0);
    MapExpandKt.putData(localViewSetter.ownerConfig.getViewRootAreaMap$plugin_autoaccessibility_release(), localViewSetter.getViewId$plugin_autoaccessibility_release(), localViewSetter.getRootId$plugin_autoaccessibility_release(), new int[] { paramInt1, paramInt2, paramInt3, paramInt4 });
    localViewSetter = (ViewSetter)this;
    AppMethodBeat.o(234470);
    return localViewSetter;
  }
  
  public final b<View, ah> getBackwardCallback$plugin_autoaccessibility_release()
  {
    return this.backwardCallback;
  }
  
  public final Integer getContentRes$plugin_autoaccessibility_release()
  {
    return this.contentRes;
  }
  
  public final String getContentResType$plugin_autoaccessibility_release()
  {
    return this.contentResType;
  }
  
  public final b<View, String> getDescCallback$plugin_autoaccessibility_release()
  {
    return this.descCallback;
  }
  
  public final boolean getDisable$plugin_autoaccessibility_release()
  {
    return this.disable;
  }
  
  public final boolean getDisableChild$plugin_autoaccessibility_release()
  {
    return this.disableChild;
  }
  
  public final b<View, ah> getForwardCallback$plugin_autoaccessibility_release()
  {
    return this.forwardCallback;
  }
  
  public final int getRootId$plugin_autoaccessibility_release()
  {
    return this.rootId;
  }
  
  public final ViewType getType$plugin_autoaccessibility_release()
  {
    return this.type;
  }
  
  public final int getViewId$plugin_autoaccessibility_release()
  {
    return this.viewId;
  }
  
  public final ViewSetter onSeekBackward(b<? super View, ah> paramb)
  {
    AppMethodBeat.i(234503);
    s.u(paramb, "backwardCallback");
    ((ViewSetter)this).setBackwardCallback$plugin_autoaccessibility_release(paramb);
    paramb = (ViewSetter)this;
    AppMethodBeat.o(234503);
    return paramb;
  }
  
  public final ViewSetter onSeekForward(b<? super View, ah> paramb)
  {
    AppMethodBeat.i(234497);
    s.u(paramb, "forwardCallback");
    ((ViewSetter)this).setForwardCallback$plugin_autoaccessibility_release(paramb);
    paramb = (ViewSetter)this;
    AppMethodBeat.o(234497);
    return paramb;
  }
  
  public final void setBackwardCallback$plugin_autoaccessibility_release(b<? super View, ah> paramb)
  {
    this.backwardCallback = paramb;
  }
  
  public final ViewSetter setContentDesc$plugin_autoaccessibility_release(int paramInt)
  {
    AppMethodBeat.i(234458);
    ViewSetter localViewSetter = (ViewSetter)this;
    localViewSetter.setContentResType$plugin_autoaccessibility_release("string_resource_type");
    localViewSetter.setContentRes$plugin_autoaccessibility_release(Integer.valueOf(paramInt));
    localViewSetter = (ViewSetter)this;
    AppMethodBeat.o(234458);
    return localViewSetter;
  }
  
  public final ViewSetter setContentDescByAnotherView$plugin_autoaccessibility_release(int paramInt)
  {
    AppMethodBeat.i(234457);
    ViewSetter localViewSetter = (ViewSetter)this;
    localViewSetter.setContentResType$plugin_autoaccessibility_release("id_resource_type");
    localViewSetter.setContentRes$plugin_autoaccessibility_release(Integer.valueOf(paramInt));
    localViewSetter = (ViewSetter)this;
    AppMethodBeat.o(234457);
    return localViewSetter;
  }
  
  public final void setContentRes$plugin_autoaccessibility_release(Integer paramInteger)
  {
    this.contentRes = paramInteger;
  }
  
  public final void setContentResType$plugin_autoaccessibility_release(String paramString)
  {
    this.contentResType = paramString;
  }
  
  public final void setDescCallback$plugin_autoaccessibility_release(b<? super View, String> paramb)
  {
    this.descCallback = paramb;
  }
  
  public final void setDisable$plugin_autoaccessibility_release(boolean paramBoolean)
  {
    this.disable = paramBoolean;
  }
  
  public final void setDisableChild$plugin_autoaccessibility_release(boolean paramBoolean)
  {
    this.disableChild = paramBoolean;
  }
  
  public final void setForwardCallback$plugin_autoaccessibility_release(b<? super View, ah> paramb)
  {
    this.forwardCallback = paramb;
  }
  
  public final void setType$plugin_autoaccessibility_release(ViewType paramViewType)
  {
    this.type = paramViewType;
  }
  
  public final ViewSetter talkOn(int paramInt, b<? super View, Boolean> paramb)
  {
    AppMethodBeat.i(234466);
    s.u(paramb, "function");
    ViewSetter localViewSetter = (ViewSetter)this;
    MapExpandKt.putData(localViewSetter.ownerConfig.getTalkMap$plugin_autoaccessibility_release(), localViewSetter.getViewId$plugin_autoaccessibility_release(), localViewSetter.getRootId$plugin_autoaccessibility_release(), paramb);
    MapExpandKt.putData(localViewSetter.ownerConfig.getTalkStringMap$plugin_autoaccessibility_release(), localViewSetter.getViewId$plugin_autoaccessibility_release(), localViewSetter.getRootId$plugin_autoaccessibility_release(), Integer.valueOf(paramInt));
    paramb = (ViewSetter)this;
    AppMethodBeat.o(234466);
    return paramb;
  }
  
  public final ViewSetter talkOn(b<? super View, Boolean> paramb)
  {
    AppMethodBeat.i(234464);
    s.u(paramb, "function");
    ViewSetter localViewSetter = (ViewSetter)this;
    MapExpandKt.putData(localViewSetter.ownerConfig.getTalkMap$plugin_autoaccessibility_release(), localViewSetter.getViewId$plugin_autoaccessibility_release(), localViewSetter.getRootId$plugin_autoaccessibility_release(), paramb);
    paramb = (ViewSetter)this;
    AppMethodBeat.o(234464);
    return paramb;
  }
  
  public final ViewSetter type(ViewType paramViewType)
  {
    AppMethodBeat.i(234455);
    s.u(paramViewType, "type");
    ((ViewSetter)this).setType$plugin_autoaccessibility_release(paramViewType);
    paramViewType = (ViewSetter)this;
    AppMethodBeat.o(234455);
    return paramViewType;
  }
  
  public final ViewSetter valueByKey(String paramString)
  {
    AppMethodBeat.i(234461);
    s.u(paramString, "key");
    ViewSetter localViewSetter = (ViewSetter)this;
    localViewSetter.placeHolderValueList.add("param_method_type");
    localViewSetter.placeHolderValueList.add(paramString);
    CharSequence localCharSequence = (CharSequence)localViewSetter.ownerConfig.getParamMap$plugin_autoaccessibility_release().get(paramString);
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localViewSetter.ownerConfig.getParamMap$plugin_autoaccessibility_release().put(paramString, "");
      }
      paramString = (ViewSetter)this;
      AppMethodBeat.o(234461);
      return paramString;
    }
  }
  
  public final ViewSetter valueByString(int paramInt)
  {
    AppMethodBeat.i(234460);
    ViewSetter localViewSetter = (ViewSetter)this;
    localViewSetter.placeHolderValueList.add("string_resource_type");
    localViewSetter.placeHolderValueList.add(Integer.valueOf(paramInt));
    localViewSetter = (ViewSetter)this;
    AppMethodBeat.o(234460);
    return localViewSetter;
  }
  
  public final ViewSetter valueByView(int paramInt)
  {
    AppMethodBeat.i(234459);
    ViewSetter localViewSetter = (ViewSetter)this;
    localViewSetter.placeHolderValueList.add("id_resource_type");
    localViewSetter.placeHolderValueList.add(Integer.valueOf(paramInt));
    localViewSetter = (ViewSetter)this;
    AppMethodBeat.o(234459);
    return localViewSetter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.base.ViewSetter
 * JD-Core Version:    0.7.0.1
 */