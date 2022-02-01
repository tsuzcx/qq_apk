package com.tencent.mm.plugin.finder.view;

import android.content.ClipboardManager;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/SignatureEditText;", "Lcom/tencent/mm/ui/widget/MMEditText;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allowEmptyLine", "", "getAllowEmptyLine", "()Z", "setAllowEmptyLine", "(Z)V", "clipboard", "Landroid/content/ClipboardManager;", "getClipboard", "()Landroid/content/ClipboardManager;", "clipboard$delegate", "Lkotlin/Lazy;", "getOriginText", "Landroid/text/Editable;", "getText", "onTextContextMenuItem", "id", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SignatureEditText
  extends MMEditText
{
  private boolean GFj;
  private final j GxL;
  
  public SignatureEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(344340);
    this.GxL = kotlin.k.cm((a)new a(this));
    addTextChangedListener((TextWatcher)new TextWatcher()
    {
      private int EVj;
      
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(344956);
        if (paramAnonymousCharSequence == null) {}
        for (paramAnonymousInt1 = 0;; paramAnonymousInt1 = paramAnonymousCharSequence.length())
        {
          this.EVj = paramAnonymousInt1;
          AppMethodBeat.o(344956);
          return;
        }
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        int i = 0;
        AppMethodBeat.i(344969);
        SignatureEditText localSignatureEditText;
        Object localObject;
        if (!this.GFk.getAllowEmptyLine())
        {
          localSignatureEditText = this.GFk;
          localObject = (1)this;
          if (paramAnonymousCharSequence == null)
          {
            paramAnonymousInt1 = 0;
            if (paramAnonymousInt1 >= ((1)localObject).EVj) {
              break label297;
            }
            if (localSignatureEditText.getSelectionEnd() - 1 <= 0) {
              break label206;
            }
            paramAnonymousInt3 = localSignatureEditText.getSelectionEnd();
            label62:
            localObject = SignatureEditText.a(localSignatureEditText);
            if (paramAnonymousInt3 >= ((Editable)localObject).length()) {
              break label297;
            }
            Iterator localIterator = n.bw((CharSequence)localObject).iterator();
            paramAnonymousInt2 = 0;
            label98:
            if (!localIterator.hasNext()) {
              break label315;
            }
            paramAnonymousCharSequence = (String)localIterator.next();
            paramAnonymousInt1 = paramAnonymousCharSequence.length();
            if (paramAnonymousInt2 > paramAnonymousInt3) {
              break label217;
            }
            if (paramAnonymousInt3 > paramAnonymousInt1 + paramAnonymousInt2) {
              break label212;
            }
            paramAnonymousInt1 = 1;
            label140:
            if (paramAnonymousInt1 == 0) {
              break label222;
            }
          }
        }
        for (;;)
        {
          if (paramAnonymousInt2 < ((Editable)localObject).length())
          {
            paramAnonymousInt3 = kotlin.k.k.qv(paramAnonymousCharSequence.length() + paramAnonymousInt2, ((Editable)localObject).length() - 1);
            if (paramAnonymousCharSequence == null)
            {
              paramAnonymousCharSequence = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
              AppMethodBeat.o(344969);
              throw paramAnonymousCharSequence;
              paramAnonymousInt1 = paramAnonymousCharSequence.length();
              break;
              label206:
              paramAnonymousInt3 = 0;
              break label62;
              label212:
              paramAnonymousInt1 = 0;
              break label140;
              label217:
              paramAnonymousInt1 = 0;
              break label140;
              label222:
              paramAnonymousInt2 = paramAnonymousCharSequence.length() + 1 + paramAnonymousInt2;
              break label98;
            }
            if (((CharSequence)n.bq((CharSequence)paramAnonymousCharSequence).toString()).length() != 0) {
              break label303;
            }
            paramAnonymousInt1 = 1;
            if (paramAnonymousInt1 != 0)
            {
              localSignatureEditText.setText(n.j((CharSequence)SignatureEditText.a(localSignatureEditText), paramAnonymousInt2, paramAnonymousInt3 + 1));
              if (paramAnonymousInt2 - 1 > 0) {
                break label308;
              }
            }
          }
          label297:
          label303:
          label308:
          for (paramAnonymousInt1 = i;; paramAnonymousInt1 = paramAnonymousInt2 - 1)
          {
            localSignatureEditText.setSelection(paramAnonymousInt1);
            AppMethodBeat.o(344969);
            return;
            paramAnonymousInt1 = 0;
            break;
          }
          label315:
          paramAnonymousCharSequence = "";
        }
      }
    });
    setOnEditorActionListener(new SignatureEditText..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(344340);
  }
  
  public SignatureEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(344347);
    this.GxL = kotlin.k.cm((a)new a(this));
    addTextChangedListener((TextWatcher)new TextWatcher()
    {
      private int EVj;
      
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(344956);
        if (paramAnonymousCharSequence == null) {}
        for (paramAnonymousInt1 = 0;; paramAnonymousInt1 = paramAnonymousCharSequence.length())
        {
          this.EVj = paramAnonymousInt1;
          AppMethodBeat.o(344956);
          return;
        }
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        int i = 0;
        AppMethodBeat.i(344969);
        SignatureEditText localSignatureEditText;
        Object localObject;
        if (!this.GFk.getAllowEmptyLine())
        {
          localSignatureEditText = this.GFk;
          localObject = (1)this;
          if (paramAnonymousCharSequence == null)
          {
            paramAnonymousInt1 = 0;
            if (paramAnonymousInt1 >= ((1)localObject).EVj) {
              break label297;
            }
            if (localSignatureEditText.getSelectionEnd() - 1 <= 0) {
              break label206;
            }
            paramAnonymousInt3 = localSignatureEditText.getSelectionEnd();
            label62:
            localObject = SignatureEditText.a(localSignatureEditText);
            if (paramAnonymousInt3 >= ((Editable)localObject).length()) {
              break label297;
            }
            Iterator localIterator = n.bw((CharSequence)localObject).iterator();
            paramAnonymousInt2 = 0;
            label98:
            if (!localIterator.hasNext()) {
              break label315;
            }
            paramAnonymousCharSequence = (String)localIterator.next();
            paramAnonymousInt1 = paramAnonymousCharSequence.length();
            if (paramAnonymousInt2 > paramAnonymousInt3) {
              break label217;
            }
            if (paramAnonymousInt3 > paramAnonymousInt1 + paramAnonymousInt2) {
              break label212;
            }
            paramAnonymousInt1 = 1;
            label140:
            if (paramAnonymousInt1 == 0) {
              break label222;
            }
          }
        }
        for (;;)
        {
          if (paramAnonymousInt2 < ((Editable)localObject).length())
          {
            paramAnonymousInt3 = kotlin.k.k.qv(paramAnonymousCharSequence.length() + paramAnonymousInt2, ((Editable)localObject).length() - 1);
            if (paramAnonymousCharSequence == null)
            {
              paramAnonymousCharSequence = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
              AppMethodBeat.o(344969);
              throw paramAnonymousCharSequence;
              paramAnonymousInt1 = paramAnonymousCharSequence.length();
              break;
              label206:
              paramAnonymousInt3 = 0;
              break label62;
              label212:
              paramAnonymousInt1 = 0;
              break label140;
              label217:
              paramAnonymousInt1 = 0;
              break label140;
              label222:
              paramAnonymousInt2 = paramAnonymousCharSequence.length() + 1 + paramAnonymousInt2;
              break label98;
            }
            if (((CharSequence)n.bq((CharSequence)paramAnonymousCharSequence).toString()).length() != 0) {
              break label303;
            }
            paramAnonymousInt1 = 1;
            if (paramAnonymousInt1 != 0)
            {
              localSignatureEditText.setText(n.j((CharSequence)SignatureEditText.a(localSignatureEditText), paramAnonymousInt2, paramAnonymousInt3 + 1));
              if (paramAnonymousInt2 - 1 > 0) {
                break label308;
              }
            }
          }
          label297:
          label303:
          label308:
          for (paramAnonymousInt1 = i;; paramAnonymousInt1 = paramAnonymousInt2 - 1)
          {
            localSignatureEditText.setSelection(paramAnonymousInt1);
            AppMethodBeat.o(344969);
            return;
            paramAnonymousInt1 = 0;
            break;
          }
          label315:
          paramAnonymousCharSequence = "";
        }
      }
    });
    setOnEditorActionListener(new SignatureEditText..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(344347);
  }
  
  private static final boolean a(SignatureEditText paramSignatureEditText, TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(344366);
    s.u(paramSignatureEditText, "this$0");
    if ((paramKeyEvent.getKeyCode() == 66) && (!paramSignatureEditText.getAllowEmptyLine()))
    {
      paramInt = paramSignatureEditText.getSelectionEnd();
      if (paramInt < paramSignatureEditText.getOriginText().length())
      {
        if (paramInt <= 0)
        {
          AppMethodBeat.o(344366);
          return true;
        }
        int i = paramSignatureEditText.getText().charAt(paramInt);
        if ((paramSignatureEditText.getText().charAt(paramInt - 1) != '\n') && (i != 10)) {}
        for (paramInt = 1; paramInt == 0; paramInt = 0)
        {
          AppMethodBeat.o(344366);
          return true;
        }
      }
      if (paramInt == paramSignatureEditText.getOriginText().length())
      {
        paramSignatureEditText = (String)p.oM(n.bw((CharSequence)paramSignatureEditText.getOriginText()));
        if (paramSignatureEditText == null)
        {
          paramSignatureEditText = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
          AppMethodBeat.o(344366);
          throw paramSignatureEditText;
        }
        if (((CharSequence)n.bq((CharSequence)paramSignatureEditText).toString()).length() == 0)
        {
          AppMethodBeat.o(344366);
          return true;
        }
        AppMethodBeat.o(344366);
        return false;
      }
    }
    AppMethodBeat.o(344366);
    return false;
  }
  
  private final ClipboardManager getClipboard()
  {
    AppMethodBeat.i(344352);
    ClipboardManager localClipboardManager = (ClipboardManager)this.GxL.getValue();
    AppMethodBeat.o(344352);
    return localClipboardManager;
  }
  
  private final Editable getOriginText()
  {
    AppMethodBeat.i(344358);
    Editable localEditable = super.getText();
    s.s(localEditable, "super.getText()");
    AppMethodBeat.o(344358);
    return localEditable;
  }
  
  public final boolean getAllowEmptyLine()
  {
    return this.GFj;
  }
  
  public final Editable getText()
  {
    AppMethodBeat.i(344384);
    Editable localEditable = super.getText();
    if (!this.GFj)
    {
      s.s(localEditable, "text");
      CharSequence localCharSequence = (CharSequence)localEditable;
      new kotlin.n.k("(?m)^[ \t]*\r?\n").e(localCharSequence, "");
    }
    s.s(localEditable, "text");
    AppMethodBeat.o(344384);
    return localEditable;
  }
  
  public final boolean onTextContextMenuItem(int paramInt)
  {
    AppMethodBeat.i(344388);
    if ((paramInt == 16908322) && (getClipboard().hasText()))
    {
      Object localObject = getClipboard().getText();
      s.s(localObject, "clipboard.text");
      localObject = new kotlin.n.k("(?m)^[ \t]*\r?\n").e((CharSequence)localObject, "");
      getClipboard().setText((CharSequence)localObject);
    }
    boolean bool = super.onTextContextMenuItem(paramInt);
    AppMethodBeat.o(344388);
    return bool;
  }
  
  public final void setAllowEmptyLine(boolean paramBoolean)
  {
    this.GFj = paramBoolean;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/content/ClipboardManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ClipboardManager>
  {
    a(SignatureEditText paramSignatureEditText)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.SignatureEditText
 * JD-Core Version:    0.7.0.1
 */