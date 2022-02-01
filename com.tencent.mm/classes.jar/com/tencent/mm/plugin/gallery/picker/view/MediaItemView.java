package com.tencent.mm.plugin.gallery.picker.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.gallery.b.e;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView;", "T", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;", "setAdapter", "(Lcom/tencent/mm/plugin/gallery/picker/adapter/GalleryPickerAdapter;)V", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "getHolder", "()Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "setHolder", "(Lcom/tencent/mm/ui/base/adapter/ViewWrapper;)V", "loader", "Lcom/tencent/mm/loader/Loader;", "getLoader", "()Lcom/tencent/mm/loader/Loader;", "setLoader", "(Lcom/tencent/mm/loader/Loader;)V", "onItemMediaSelectedListener", "Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "getOnItemMediaSelectedListener", "()Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "setOnItemMediaSelectedListener", "(Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;)V", "selectedList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getSelectedList", "()Ljava/util/ArrayList;", "setSelectedList", "(Ljava/util/ArrayList;)V", "selectedSet", "Ljava/util/HashSet;", "getSelectedSet", "()Ljava/util/HashSet;", "setSelectedSet", "(Ljava/util/HashSet;)V", "animVisible", "", "v", "Landroid/view/View;", "targetVisibility", "isAnim", "", "disableSelected", "enableSelected", "getLayoutId", "isSelectedEnable", "media", "(Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;)Z", "onCovert", "covertType", "(Lcom/tencent/mm/ui/base/adapter/ViewWrapper;Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;Lcom/tencent/mm/loader/Loader;I)V", "onCreateView", "onSelectItem", "isSelected", "Companion", "OnItemMediaSelectedListener", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class MediaItemView<T extends GalleryItem.MediaItem>
  extends FrameLayout
{
  public static final MediaItemView.a HLf = new MediaItemView.a((byte)0);
  public com.tencent.mm.plugin.gallery.picker.a.a HIV;
  public HashSet<T> HJm;
  private b<?> HJp;
  public com.tencent.mm.ui.base.a.b HKj;
  public d<T> mgk;
  public ArrayList<T> nog;
  
  public MediaItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MediaItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MediaItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private static final void a(MediaItemView paramMediaItemView, HashSet paramHashSet, ArrayList paramArrayList, d paramd, CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    s.u(paramMediaItemView, "this$0");
    s.u(paramHashSet, "$selectedSet");
    s.u(paramArrayList, "$selectedList");
    s.u(paramd, "$loader");
    paramCompoundButton = (GalleryItem.MediaItem)paramMediaItemView.getHolder().CSA;
    if (paramBoolean != paramHashSet.contains(paramCompoundButton))
    {
      if (!paramBoolean) {
        break label125;
      }
      if (paramHashSet.add(paramCompoundButton)) {
        paramArrayList.add(paramCompoundButton);
      }
      paramHashSet = paramMediaItemView.getHolder();
      s.s(paramCompoundButton, "media");
      a(paramMediaItemView, paramHashSet, paramCompoundButton, paramd);
      paramHashSet = paramMediaItemView.getOnItemMediaSelectedListener();
      if (paramHashSet != null)
      {
        paramArrayList = paramMediaItemView.getHolder();
        paramMediaItemView = paramMediaItemView.getHolder().CSA;
        s.s(paramMediaItemView, "holder.getAssociatedObject()");
        paramHashSet.b(paramArrayList, paramMediaItemView);
      }
    }
    label125:
    do
    {
      return;
      paramHashSet.remove(paramCompoundButton);
      paramArrayList.remove(paramCompoundButton);
      paramHashSet = paramMediaItemView.getHolder();
      s.s(paramCompoundButton, "media");
      a(paramMediaItemView, paramHashSet, paramCompoundButton, paramd);
      paramHashSet = paramMediaItemView.getOnItemMediaSelectedListener();
    } while (paramHashSet == null);
    paramArrayList = paramMediaItemView.getHolder();
    paramMediaItemView = paramMediaItemView.getHolder().CSA;
    s.s(paramMediaItemView, "holder.getAssociatedObject()");
    paramHashSet.a(paramArrayList, paramMediaItemView);
  }
  
  private static final void ax(View paramView, int paramInt)
  {
    s.u(paramView, "$v");
    paramView.setVisibility(0);
    switch (paramInt)
    {
    }
    for (float f = 0.0F;; f = 1.0F)
    {
      paramView.setAlpha(f);
      return;
    }
  }
  
  private static final void ay(View paramView, int paramInt)
  {
    s.u(paramView, "$v");
    paramView.setVisibility(paramInt);
    paramView.setAlpha(1.0F);
  }
  
  private static final void b(CheckBox paramCheckBox, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramCheckBox);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/gallery/picker/view/MediaItemView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    if (!paramCheckBox.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramCheckBox.setChecked(bool);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/gallery/picker/view/MediaItemView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      return;
    }
  }
  
  private static void g(View paramView, int paramInt, boolean paramBoolean)
  {
    float f = 1.0F;
    Log.d("MediaItemView", "[animVisible] isAnim=" + paramBoolean + " view=" + paramView.hashCode());
    if (paramView.getVisibility() == paramInt) {
      return;
    }
    if (!paramBoolean)
    {
      paramView.setVisibility(paramInt);
      paramView.setAlpha(1.0F);
      return;
    }
    ViewPropertyAnimator localViewPropertyAnimator = paramView.animate();
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.cancel();
    }
    paramView = paramView.animate().withStartAction(new MediaItemView..ExternalSyntheticLambda2(paramView, paramInt)).withEndAction(new MediaItemView..ExternalSyntheticLambda3(paramView, paramInt)).setDuration(300L);
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramView.alpha(f).start();
      return;
      f = 0.0F;
    }
  }
  
  public final void a(d<T> paramd, HashSet<T> paramHashSet, ArrayList<T> paramArrayList, com.tencent.mm.plugin.gallery.picker.a.a parama)
  {
    s.u(paramd, "loader");
    s.u(paramHashSet, "selectedSet");
    s.u(paramArrayList, "selectedList");
    s.u(parama, "adapter");
    setAdapter(parama);
    setLoader(paramd);
    setSelectedSet(paramHashSet);
    setSelectedList(paramArrayList);
    Object localObject = af.mU(getContext()).inflate(getLayoutId(), (ViewGroup)this);
    float f = getResources().getDisplayMetrics().widthPixels / 4 - 8.0F;
    ((View)localObject).setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams((int)f, (int)f));
    parama = ((View)localObject).findViewById(b.e.media_select_area);
    localObject = (CheckBox)((View)localObject).findViewById(b.e.media_cbx);
    ((CheckBox)localObject).setOnCheckedChangeListener(new MediaItemView..ExternalSyntheticLambda1(this, paramHashSet, paramArrayList, paramd));
    parama.setOnClickListener(new MediaItemView..ExternalSyntheticLambda0((CheckBox)localObject));
  }
  
  public void a(com.tencent.mm.ui.base.a.b paramb, T paramT, d<T> paramd, int paramInt)
  {
    boolean bool2 = true;
    s.u(paramb, "holder");
    s.u(paramT, "media");
    s.u(paramd, "loader");
    setHolder(paramb);
    paramb.CSA = paramT;
    switch (paramInt)
    {
    default: 
      s.u(paramT, "media");
      if (getSelectedSet().size() >= 9)
      {
        bool1 = getSelectedSet().contains(paramT);
        label84:
        if (!bool1) {
          break label391;
        }
        if (paramInt != 2) {
          break label385;
        }
      }
      break;
    }
    label385:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramb = getHolder().UH(b.e.media_select_area);
      paramT = (CheckBox)getHolder().UH(b.e.media_cbx);
      paramd = getHolder().UH(b.e.media_mask_area);
      s.s(paramT, "mediaSelectBox");
      g((View)paramT, 0, bool1);
      s.s(paramd, "mediaMaskArea");
      g(paramd, 4, bool1);
      paramT.setEnabled(true);
      paramb.setEnabled(true);
      return;
      paramd = (CheckBox)paramb.UH(b.e.media_cbx);
      paramd.setChecked(getSelectedSet().contains(paramT));
      if ((paramT.getType() == 1) && (paramd.isChecked()))
      {
        bool1 = true;
        label217:
        paramd.setSelected(bool1);
        if ((!getAdapter().HJe) || (getSelectedList().size() <= 0) || (!paramd.isChecked()) || (paramT.getType() != 1)) {
          break label289;
        }
      }
      label289:
      for (paramb = (CharSequence)String.valueOf(getSelectedList().indexOf(paramT) + 1);; paramb = (CharSequence)"")
      {
        paramd.setText(paramb);
        break;
        bool1 = false;
        break label217;
      }
      paramb = (GalleryItem.MediaItem)p.oL((List)getSelectedList());
      if (paramb != null)
      {
        if ((paramb.getType() == 2) && (paramb.HHJ != paramT.HHJ) && (paramT.getType() != 2))
        {
          bool1 = false;
          break label84;
        }
        if ((paramb.getType() == 1) && (paramT.getType() == 2))
        {
          bool1 = false;
          break label84;
        }
        bool1 = true;
        break label84;
      }
      bool1 = true;
      break label84;
    }
    label391:
    if (paramInt == 2) {}
    for (bool1 = bool2;; bool1 = false)
    {
      paramb = getHolder().UH(b.e.media_select_area);
      paramT = (CheckBox)getHolder().UH(b.e.media_cbx);
      paramd = getHolder().UH(b.e.media_mask_area);
      s.s(paramT, "mediaSelectBox");
      g((View)paramT, 4, bool1);
      s.s(paramd, "mediaGrepArea");
      g(paramd, 0, bool1);
      paramT.setSelected(false);
      paramT.setChecked(false);
      paramT.setEnabled(false);
      paramb.setEnabled(false);
      return;
    }
  }
  
  public final com.tencent.mm.plugin.gallery.picker.a.a getAdapter()
  {
    com.tencent.mm.plugin.gallery.picker.a.a locala = this.HIV;
    if (locala != null) {
      return locala;
    }
    s.bIx("adapter");
    return null;
  }
  
  public final com.tencent.mm.ui.base.a.b getHolder()
  {
    com.tencent.mm.ui.base.a.b localb = this.HKj;
    if (localb != null) {
      return localb;
    }
    s.bIx("holder");
    return null;
  }
  
  public abstract int getLayoutId();
  
  public final d<T> getLoader()
  {
    d locald = this.mgk;
    if (locald != null) {
      return locald;
    }
    s.bIx("loader");
    return null;
  }
  
  public final b<?> getOnItemMediaSelectedListener()
  {
    return this.HJp;
  }
  
  public final ArrayList<T> getSelectedList()
  {
    ArrayList localArrayList = this.nog;
    if (localArrayList != null) {
      return localArrayList;
    }
    s.bIx("selectedList");
    return null;
  }
  
  public final HashSet<T> getSelectedSet()
  {
    HashSet localHashSet = this.HJm;
    if (localHashSet != null) {
      return localHashSet;
    }
    s.bIx("selectedSet");
    return null;
  }
  
  public final void setAdapter(com.tencent.mm.plugin.gallery.picker.a.a parama)
  {
    s.u(parama, "<set-?>");
    this.HIV = parama;
  }
  
  public final void setHolder(com.tencent.mm.ui.base.a.b paramb)
  {
    s.u(paramb, "<set-?>");
    this.HKj = paramb;
  }
  
  public final void setLoader(d<T> paramd)
  {
    s.u(paramd, "<set-?>");
    this.mgk = paramd;
  }
  
  public final void setOnItemMediaSelectedListener(b<?> paramb)
  {
    this.HJp = paramb;
  }
  
  public final void setSelectedList(ArrayList<T> paramArrayList)
  {
    s.u(paramArrayList, "<set-?>");
    this.nog = paramArrayList;
  }
  
  public final void setSelectedSet(HashSet<T> paramHashSet)
  {
    s.u(paramHashSet, "<set-?>");
    this.HJm = paramHashSet;
  }
  
  public final void uu(boolean paramBoolean)
  {
    CheckBox localCheckBox = (CheckBox)getHolder().UH(b.e.media_cbx);
    if (localCheckBox.isEnabled()) {
      localCheckBox.setChecked(paramBoolean);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/view/MediaItemView$OnItemMediaSelectedListener;", "E", "", "onMediaSelected", "", "holder", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "media", "(Lcom/tencent/mm/ui/base/adapter/ViewWrapper;Ljava/lang/Object;)V", "onMediaUnSelected", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b<E>
  {
    public abstract void a(com.tencent.mm.ui.base.a.b paramb, E paramE);
    
    public abstract void b(com.tencent.mm.ui.base.a.b paramb, E paramE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.view.MediaItemView
 * JD-Core Version:    0.7.0.1
 */