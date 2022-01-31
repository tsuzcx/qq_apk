package com.tencent.mm.plugin.emojicapture.ui.editor;

import a.d.b.g;
import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.emojicapture.a.d;
import com.tencent.mm.plugin.emojicapture.a.e;
import com.tencent.mm.plugin.emojicapture.a.f;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.List;

public final class EditorItemContainer
  extends RelativeLayout
{
  public static final a jpZ = new a((byte)0);
  private final String TAG = "MicroMsg.EditorItemContainer";
  public View jpS;
  private TextView jpT;
  private EditorItemContainer.b jpU;
  private final RectF jpV = new RectF();
  public a jpW;
  public Runnable jpX = (Runnable)new c(this);
  public a jpY;
  
  public EditorItemContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EditorItemContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    View.inflate(paramContext, a.e.emoji_capture_editor_item_container, (ViewGroup)this);
    paramContext = findViewById(a.d.editor_valid_area);
    g.j(paramContext, "findViewById(R.id.editor_valid_area)");
    this.jpS = paramContext;
    paramContext = findViewById(a.d.editor_delete_view);
    g.j(paramContext, "findViewById(R.id.editor_delete_view)");
    this.jpT = ((TextView)paramContext);
  }
  
  private final void fz(boolean paramBoolean)
  {
    this.jpT.setActivated(paramBoolean);
    if (paramBoolean)
    {
      this.jpT.setText(a.f.editor_item_release_to_delete);
      return;
    }
    this.jpT.setText(a.f.editor_item_drag_to_delete);
  }
  
  public final void a(a parama, boolean paramBoolean)
  {
    g.k(parama, "itemView");
    if (paramBoolean) {
      if ((g.e(parama, this.jpW) ^ true))
      {
        a locala = this.jpW;
        if (locala != null) {
          locala.setEditing(false);
        }
        this.jpW = parama;
      }
    }
    for (;;)
    {
      parama.setEditing(paramBoolean);
      return;
      if (g.e(parama, this.jpW)) {
        this.jpW = null;
      }
    }
  }
  
  public final boolean a(a parama, MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getPointerCount();
    float f = 0.0F;
    int i = 0;
    while (i < j)
    {
      f += paramMotionEvent.getY(i);
      i += 1;
    }
    boolean bool;
    if (f / j > this.jpT.getTop())
    {
      bool = true;
      if (!bool) {
        break label87;
      }
      fz(true);
      if (this.jpY == null) {
        this.jpY = parama;
      }
    }
    label87:
    do
    {
      return bool;
      bool = false;
      break;
      fz(false);
    } while (this.jpY == null);
    this.jpY = null;
    return bool;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public final void fy(boolean paramBoolean)
  {
    Object localObject = this.jpT;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((TextView)localObject).setVisibility(i);
      if (this.jpU != null)
      {
        localObject = this.jpU;
        if (localObject == null) {
          g.cUk();
        }
        ((EditorItemContainer.b)localObject).fx(paramBoolean);
      }
      return;
    }
  }
  
  public final ArrayList<String> getAllEmojiMd5()
  {
    ArrayList localArrayList = new ArrayList();
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = getChildAt(i);
      if ((localObject instanceof EmojiEditorItemView))
      {
        localObject = ((EmojiEditorItemView)localObject).getEmojiInfo();
        if (localObject != null)
        {
          localObject = ((EmojiInfo)localObject).Wv();
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public final List<a> getAllItemViews()
  {
    List localList = (List)new ArrayList();
    int i = 0;
    int j = getChildCount();
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((localView instanceof a)) {
        localList.add(localView);
      }
      i += 1;
    }
    return localList;
  }
  
  public final String getAttachedText()
  {
    TextEditorItemView localTextEditorItemView = getTextItem();
    if (localTextEditorItemView == null) {}
    while (localTextEditorItemView.getText() == null) {
      return null;
    }
    return String.valueOf(localTextEditorItemView.getText());
  }
  
  public final EditorItemContainer.b getStateChangeListener()
  {
    return this.jpU;
  }
  
  public final TextEditorItemView getTextItem()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((localView instanceof TextEditorItemView)) {
        return (TextEditorItemView)localView;
      }
      i += 1;
    }
    return null;
  }
  
  public final RectF getValidRect()
  {
    this.jpV.set(this.jpS.getLeft(), this.jpS.getTop(), this.jpS.getRight(), this.jpS.getBottom());
    return this.jpV;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    g.k(paramMotionEvent, "ev");
    if ((paramMotionEvent.getActionMasked() == 0) && (!this.jpV.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))) {
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent != null) && (paramMotionEvent.getActionMasked() == 0))
    {
      if (!this.jpV.contains(paramMotionEvent.getX(), paramMotionEvent.getY())) {
        return false;
      }
      if (this.jpW != null)
      {
        a locala = this.jpW;
        if (locala == null) {
          g.cUk();
        }
        a(locala, false);
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public final void setStateChangeListener(EditorItemContainer.b paramb)
  {
    this.jpU = paramb;
  }
  
  public static final class a {}
  
  static final class c
    implements Runnable
  {
    c(EditorItemContainer paramEditorItemContainer) {}
    
    public final void run()
    {
      if (EditorItemContainer.c(this.jqa) != null)
      {
        EditorItemContainer localEditorItemContainer = this.jqa;
        a locala = EditorItemContainer.c(this.jqa);
        if (locala == null) {
          g.cUk();
        }
        localEditorItemContainer.a(locala, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer
 * JD-Core Version:    0.7.0.1
 */