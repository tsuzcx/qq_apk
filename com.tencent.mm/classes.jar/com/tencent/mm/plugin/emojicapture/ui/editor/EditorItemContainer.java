package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "clearActive", "Ljava/lang/Runnable;", "currActiveItem", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/IEditorItemView;", "deleteView", "Landroid/widget/TextView;", "deletingItem", "editorMask", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorOutsideView;", "itemLayout", "Landroid/view/ViewGroup;", "stateChangeListener", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer$OnStateChangeListener;", "getStateChangeListener", "()Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer$OnStateChangeListener;", "setStateChangeListener", "(Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer$OnStateChangeListener;)V", "validAreaView", "Landroid/view/View;", "validRect", "Landroid/graphics/RectF;", "activeDeleteView", "", "active", "", "addEditorItem", "itemView", "createTextItem", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/TextEditorItemView;", "deleteCheck", "event", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "ev", "getAllEmojiMd5", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getAllItemViews", "", "getAttachedText", "getTextItem", "getValidRect", "handleItemTouch", "onInterceptTouchEvent", "onTouchEvent", "pause", "removeAllItems", "requestEditing", "editing", "resume", "setEditing", "setValidRect", "left", "", "top", "right", "bottom", "toggleDeleteView", "show", "Companion", "OnStateChangeListener", "plugin-emojicapture_release"})
public final class EditorItemContainer
  extends RelativeLayout
{
  public static final EditorItemContainer.a lzK;
  private final String TAG;
  private View lzB;
  private TextView lzC;
  public final ViewGroup lzD;
  public final EditorOutsideView lzE;
  private EditorItemContainer.b lzF;
  private final RectF lzG;
  private a lzH;
  private Runnable lzI;
  private a lzJ;
  
  static
  {
    AppMethodBeat.i(3092);
    lzK = new EditorItemContainer.a((byte)0);
    AppMethodBeat.o(3092);
  }
  
  public EditorItemContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(3091);
    AppMethodBeat.o(3091);
  }
  
  public EditorItemContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(3090);
    this.TAG = "MicroMsg.EditorItemContainer";
    this.lzG = new RectF();
    this.lzI = ((Runnable)new EditorItemContainer.c(this));
    View.inflate(paramContext, 2130969358, (ViewGroup)this);
    paramContext = findViewById(2131823546);
    j.p(paramContext, "findViewById(R.id.editor_valid_area)");
    this.lzB = paramContext;
    paramContext = findViewById(2131823549);
    j.p(paramContext, "findViewById(R.id.editor_delete_view)");
    this.lzC = ((TextView)paramContext);
    paramContext = findViewById(2131823547);
    j.p(paramContext, "findViewById(R.id.emoji_capture_editor_layout)");
    this.lzD = ((ViewGroup)paramContext);
    paramContext = findViewById(2131823548);
    j.p(paramContext, "findViewById(R.id.emoji_capture_editor_mask)");
    this.lzE = ((EditorOutsideView)paramContext);
    AppMethodBeat.o(3090);
  }
  
  private final boolean b(a parama, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(3089);
    int j = paramMotionEvent.getPointerCount();
    float f = 0.0F;
    int i = 0;
    while (i < j)
    {
      f += paramMotionEvent.getY(i);
      i += 1;
    }
    boolean bool;
    if (f / j > this.lzC.getTop())
    {
      bool = true;
      if (!bool) {
        break label99;
      }
      ha(true);
      if (this.lzJ == null) {
        this.lzJ = parama;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(3089);
      return bool;
      bool = false;
      break;
      label99:
      ha(false);
      if (this.lzJ != null) {
        this.lzJ = null;
      }
    }
  }
  
  private final void gZ(boolean paramBoolean)
  {
    AppMethodBeat.i(3087);
    Object localObject = this.lzC;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((TextView)localObject).setVisibility(i);
      if (this.lzF != null)
      {
        localObject = this.lzF;
        if (localObject == null) {
          j.ebi();
        }
        ((EditorItemContainer.b)localObject).gY(paramBoolean);
      }
      AppMethodBeat.o(3087);
      return;
    }
  }
  
  private final void ha(boolean paramBoolean)
  {
    AppMethodBeat.i(3088);
    this.lzC.setActivated(paramBoolean);
    if (paramBoolean)
    {
      this.lzC.setText(2131299079);
      AppMethodBeat.o(3088);
      return;
    }
    this.lzC.setText(2131299078);
    AppMethodBeat.o(3088);
  }
  
  public final void a(a parama, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(3075);
    j.q(parama, "itemView");
    j.q(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      AppMethodBeat.o(3075);
      return;
    case 0: 
      removeCallbacks(this.lzI);
      a(parama, true);
      AppMethodBeat.o(3075);
      return;
    case 2: 
      b(parama, paramMotionEvent);
      gZ(true);
      AppMethodBeat.o(3075);
      return;
    }
    this.lzD.bringChildToFront((View)getTextItem());
    if (this.lzJ != null) {
      post((Runnable)new EditorItemContainer.d(this));
    }
    for (;;)
    {
      gZ(false);
      break;
      if (this.lzH != null) {
        postDelayed(this.lzI, 1500L);
      }
    }
  }
  
  public final void a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(3086);
    j.q(parama, "itemView");
    if (paramBoolean) {
      if ((j.e(parama, this.lzH) ^ true))
      {
        a locala = this.lzH;
        if (locala != null) {
          locala.setEditing(false);
        }
        this.lzH = parama;
      }
    }
    for (;;)
    {
      parama.setEditing(paramBoolean);
      AppMethodBeat.o(3086);
      return;
      if (j.e(parama, this.lzH)) {
        this.lzH = null;
      }
    }
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(3077);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(3077);
    return bool;
  }
  
  public final ArrayList<String> getAllEmojiMd5()
  {
    AppMethodBeat.i(3081);
    ArrayList localArrayList = new ArrayList();
    int j = this.lzD.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.lzD.getChildAt(i);
      if ((localObject instanceof EmojiEditorItemView))
      {
        localObject = ((EmojiEditorItemView)localObject).getEmojiInfo();
        if (localObject != null)
        {
          localObject = ((EmojiInfo)localObject).Al();
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
      }
      i += 1;
    }
    AppMethodBeat.o(3081);
    return localArrayList;
  }
  
  public final List<a> getAllItemViews()
  {
    AppMethodBeat.i(3082);
    List localList = (List)new ArrayList();
    int i = 0;
    int j = this.lzD.getChildCount();
    while (i < j)
    {
      View localView = this.lzD.getChildAt(i);
      if ((localView instanceof a)) {
        localList.add(localView);
      }
      i += 1;
    }
    AppMethodBeat.o(3082);
    return localList;
  }
  
  public final String getAttachedText()
  {
    AppMethodBeat.i(3080);
    Object localObject = getTextItem();
    if (localObject == null)
    {
      AppMethodBeat.o(3080);
      return null;
    }
    if (((TextEditorItemView)localObject).getText() == null)
    {
      AppMethodBeat.o(3080);
      return null;
    }
    localObject = String.valueOf(((TextEditorItemView)localObject).getText());
    AppMethodBeat.o(3080);
    return localObject;
  }
  
  public final EditorItemContainer.b getStateChangeListener()
  {
    return this.lzF;
  }
  
  public final TextEditorItemView getTextItem()
  {
    AppMethodBeat.i(3079);
    int j = this.lzD.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.lzD.getChildAt(i);
      if ((localObject instanceof TextEditorItemView))
      {
        localObject = (TextEditorItemView)localObject;
        AppMethodBeat.o(3079);
        return localObject;
      }
      i += 1;
    }
    AppMethodBeat.o(3079);
    return null;
  }
  
  public final RectF getValidRect()
  {
    AppMethodBeat.i(3084);
    this.lzG.set(this.lzB.getLeft(), this.lzB.getTop(), this.lzB.getRight(), this.lzB.getBottom());
    RectF localRectF = this.lzG;
    AppMethodBeat.o(3084);
    return localRectF;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(3076);
    j.q(paramMotionEvent, "ev");
    if ((paramMotionEvent.getActionMasked() == 0) && (!this.lzG.contains(paramMotionEvent.getX(), paramMotionEvent.getY())))
    {
      AppMethodBeat.o(3076);
      return true;
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(3076);
    return bool;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(3078);
    if ((paramMotionEvent != null) && (paramMotionEvent.getActionMasked() == 0))
    {
      if (!this.lzG.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
      {
        AppMethodBeat.o(3078);
        return false;
      }
      if (this.lzH != null)
      {
        a locala = this.lzH;
        if (locala == null) {
          j.ebi();
        }
        a(locala, false);
      }
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(3078);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(3083);
    int j = this.lzD.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.lzD.getChildAt(i);
      if ((localView instanceof a)) {
        ((a)localView).pause();
      }
      i += 1;
    }
    AppMethodBeat.o(3083);
  }
  
  public final void setEditing(a parama)
  {
    AppMethodBeat.i(3085);
    j.q(parama, "itemView");
    removeCallbacks(this.lzI);
    a(parama, true);
    postDelayed(this.lzI, 1500L);
    AppMethodBeat.o(3085);
  }
  
  public final void setStateChangeListener(EditorItemContainer.b paramb)
  {
    this.lzF = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer
 * JD-Core Version:    0.7.0.1
 */