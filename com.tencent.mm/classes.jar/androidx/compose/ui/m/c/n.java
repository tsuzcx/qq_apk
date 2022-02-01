package androidx.compose.ui.m.c;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/input/RecordingInputConnection;", "Landroid/view/inputmethod/InputConnection;", "initState", "Landroidx/compose/ui/text/input/TextFieldValue;", "eventCallback", "Landroidx/compose/ui/text/input/InputEventCallback2;", "autoCorrect", "", "(Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/InputEventCallback2;Z)V", "getAutoCorrect", "()Z", "batchDepth", "", "currentExtractedTextRequestToken", "editCommands", "", "Landroidx/compose/ui/text/input/EditCommand;", "getEventCallback", "()Landroidx/compose/ui/text/input/InputEventCallback2;", "extractedTextMonitorMode", "isActive", "value", "mTextFieldValue", "getMTextFieldValue$ui_release$annotations", "()V", "getMTextFieldValue$ui_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setMTextFieldValue$ui_release", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "addEditCommandWithBatch", "", "editCommand", "beginBatchEdit", "beginBatchEditInternal", "clearMetaKeyStates", "states", "closeConnection", "commitCompletion", "text", "Landroid/view/inputmethod/CompletionInfo;", "commitContent", "inputContentInfo", "Landroid/view/inputmethod/InputContentInfo;", "flags", "opts", "Landroid/os/Bundle;", "commitCorrection", "correctionInfo", "Landroid/view/inputmethod/CorrectionInfo;", "commitText", "", "newCursorPosition", "deleteSurroundingText", "beforeLength", "afterLength", "deleteSurroundingTextInCodePoints", "endBatchEdit", "endBatchEditInternal", "ensureActive", "block", "Lkotlin/Function0;", "finishComposingText", "getCursorCapsMode", "reqModes", "getExtractedText", "Landroid/view/inputmethod/ExtractedText;", "request", "Landroid/view/inputmethod/ExtractedTextRequest;", "getHandler", "Landroid/os/Handler;", "getSelectedText", "getTextAfterCursor", "maxChars", "getTextBeforeCursor", "logDebug", "message", "", "performContextMenuAction", "id", "performEditorAction", "editorAction", "performPrivateCommand", "action", "data", "reportFullscreenMode", "enabled", "requestCursorUpdates", "cursorUpdateMode", "sendKeyEvent", "event", "Landroid/view/KeyEvent;", "setComposingRegion", "start", "end", "setComposingText", "setSelection", "updateInputState", "state", "inputMethodManager", "Landroidx/compose/ui/text/input/InputMethodManager;", "view", "Landroid/view/View;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  implements InputConnection
{
  private final boolean bcH;
  private final h bcZ;
  private int bda;
  private r bdb;
  private int bdc;
  private boolean bdd;
  private final List<d> bde;
  private boolean isActive;
  
  public n(r paramr, h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(205289);
    this.bcZ = paramh;
    this.bcH = paramBoolean;
    this.bdb = paramr;
    this.bde = ((List)new ArrayList());
    this.isActive = true;
    AppMethodBeat.o(205289);
  }
  
  private final boolean BF()
  {
    this.bda += 1;
    return true;
  }
  
  private final boolean BG()
  {
    AppMethodBeat.i(205302);
    this.bda -= 1;
    if (this.bda == 0) {
      if (((Collection)this.bde).isEmpty()) {
        break label85;
      }
    }
    label85:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.bcZ.U(kotlin.a.p.J((Collection)this.bde));
        this.bde.clear();
      }
      if (this.bda <= 0) {
        break;
      }
      AppMethodBeat.o(205302);
      return true;
    }
    AppMethodBeat.o(205302);
    return false;
  }
  
  private final void a(d paramd)
  {
    AppMethodBeat.i(205296);
    BF();
    try
    {
      this.bde.add(paramd);
      return;
    }
    finally
    {
      BG();
      AppMethodBeat.o(205296);
    }
  }
  
  public final boolean beginBatchEdit()
  {
    AppMethodBeat.i(205304);
    boolean bool = this.isActive;
    if (bool)
    {
      bool = BF();
      AppMethodBeat.o(205304);
      return bool;
    }
    AppMethodBeat.o(205304);
    return bool;
  }
  
  public final boolean clearMetaKeyStates(int paramInt)
  {
    boolean bool2 = this.isActive;
    boolean bool1 = bool2;
    if (bool2) {
      bool1 = false;
    }
    return bool1;
  }
  
  public final void closeConnection()
  {
    AppMethodBeat.i(205309);
    this.bde.clear();
    this.bda = 0;
    this.isActive = false;
    AppMethodBeat.o(205309);
  }
  
  public final boolean commitCompletion(CompletionInfo paramCompletionInfo)
  {
    boolean bool2 = this.isActive;
    boolean bool1 = bool2;
    if (bool2) {
      bool1 = false;
    }
    return bool1;
  }
  
  public final boolean commitContent(InputContentInfo paramInputContentInfo, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(205420);
    kotlin.g.b.s.u(paramInputContentInfo, "inputContentInfo");
    boolean bool = this.isActive;
    if (bool)
    {
      AppMethodBeat.o(205420);
      return false;
    }
    AppMethodBeat.o(205420);
    return bool;
  }
  
  public final boolean commitCorrection(CorrectionInfo paramCorrectionInfo)
  {
    boolean bool2 = this.isActive;
    boolean bool1 = bool2;
    if (bool2) {
      bool1 = this.bcH;
    }
    return bool1;
  }
  
  public final boolean commitText(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(205313);
    boolean bool = this.isActive;
    if (bool) {
      a((d)new a(String.valueOf(paramCharSequence), paramInt));
    }
    AppMethodBeat.o(205313);
    return bool;
  }
  
  public final boolean deleteSurroundingText(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205327);
    boolean bool = this.isActive;
    if (bool)
    {
      a((d)new b(paramInt1, paramInt2));
      AppMethodBeat.o(205327);
      return true;
    }
    AppMethodBeat.o(205327);
    return bool;
  }
  
  public final boolean deleteSurroundingTextInCodePoints(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205323);
    boolean bool = this.isActive;
    if (bool)
    {
      a((d)new c(paramInt1, paramInt2));
      AppMethodBeat.o(205323);
      return true;
    }
    AppMethodBeat.o(205323);
    return bool;
  }
  
  public final boolean endBatchEdit()
  {
    AppMethodBeat.i(205306);
    boolean bool = BG();
    AppMethodBeat.o(205306);
    return bool;
  }
  
  public final boolean finishComposingText()
  {
    AppMethodBeat.i(205332);
    boolean bool = this.isActive;
    if (bool)
    {
      a((d)new e());
      AppMethodBeat.o(205332);
      return true;
    }
    AppMethodBeat.o(205332);
    return bool;
  }
  
  public final int getCursorCapsMode(int paramInt)
  {
    AppMethodBeat.i(205411);
    paramInt = TextUtils.getCapsMode((CharSequence)this.bdb.aYS.text, androidx.compose.ui.m.s.aP(this.bdb.bdg), paramInt);
    AppMethodBeat.o(205411);
    return paramInt;
  }
  
  public final ExtractedText getExtractedText(ExtractedTextRequest paramExtractedTextRequest, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(205366);
    boolean bool;
    label36:
    ExtractedText localExtractedText;
    if ((paramInt & 0x1) != 0)
    {
      bool = true;
      this.bdd = bool;
      if (this.bdd)
      {
        if (paramExtractedTextRequest != null) {
          break label169;
        }
        paramInt = 0;
        this.bdc = paramInt;
      }
      paramExtractedTextRequest = this.bdb;
      kotlin.g.b.s.u(paramExtractedTextRequest, "<this>");
      localExtractedText = new ExtractedText();
      localExtractedText.text = ((CharSequence)paramExtractedTextRequest.aYS.text);
      localExtractedText.startOffset = 0;
      localExtractedText.partialEndOffset = paramExtractedTextRequest.aYS.text.length();
      localExtractedText.partialStartOffset = -1;
      localExtractedText.selectionStart = androidx.compose.ui.m.s.aP(paramExtractedTextRequest.bdg);
      localExtractedText.selectionEnd = androidx.compose.ui.m.s.aQ(paramExtractedTextRequest.bdg);
      if (!kotlin.n.n.d((CharSequence)paramExtractedTextRequest.aYS.text, '\n')) {
        break label177;
      }
    }
    label169:
    label177:
    for (paramInt = i;; paramInt = 1)
    {
      localExtractedText.flags = paramInt;
      AppMethodBeat.o(205366);
      return localExtractedText;
      bool = false;
      break;
      paramInt = paramExtractedTextRequest.token;
      break label36;
    }
  }
  
  public final Handler getHandler()
  {
    return null;
  }
  
  public final CharSequence getSelectedText(int paramInt)
  {
    AppMethodBeat.i(205352);
    if (androidx.compose.ui.m.s.aR(this.bdb.bdg))
    {
      AppMethodBeat.o(205352);
      return null;
    }
    Object localObject = this.bdb;
    kotlin.g.b.s.u(localObject, "<this>");
    androidx.compose.ui.m.a locala = ((r)localObject).aYS;
    long l = ((r)localObject).bdg;
    localObject = (CharSequence)locala.ah(androidx.compose.ui.m.s.aP(l), androidx.compose.ui.m.s.aQ(l)).toString();
    AppMethodBeat.o(205352);
    return localObject;
  }
  
  public final CharSequence getTextAfterCursor(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205346);
    Object localObject = this.bdb;
    kotlin.g.b.s.u(localObject, "<this>");
    localObject = (CharSequence)((r)localObject).aYS.ah(androidx.compose.ui.m.s.aQ(((r)localObject).bdg), Math.min(androidx.compose.ui.m.s.aQ(((r)localObject).bdg) + paramInt1, ((r)localObject).aYS.text.length())).toString();
    AppMethodBeat.o(205346);
    return localObject;
  }
  
  public final CharSequence getTextBeforeCursor(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205340);
    Object localObject = this.bdb;
    kotlin.g.b.s.u(localObject, "<this>");
    localObject = (CharSequence)((r)localObject).aYS.ah(Math.max(0, androidx.compose.ui.m.s.aP(((r)localObject).bdg) - paramInt1), androidx.compose.ui.m.s.aP(((r)localObject).bdg)).toString();
    AppMethodBeat.o(205340);
    return localObject;
  }
  
  public final boolean performContextMenuAction(int paramInt)
  {
    boolean bool2 = this.isActive;
    boolean bool1 = bool2;
    if (bool2) {
      bool1 = false;
    }
    return bool1;
  }
  
  public final boolean performEditorAction(int paramInt)
  {
    AppMethodBeat.i(205375);
    boolean bool = this.isActive;
    if (bool)
    {
      f.a locala;
      switch (paramInt)
      {
      case 1: 
      default: 
        kotlin.g.b.s.X("IME sends unsupported Editor Action: ", Integer.valueOf(paramInt));
        locala = f.bcy;
        paramInt = f.Bm();
      }
      for (;;)
      {
        this.bcZ.dA(paramInt);
        AppMethodBeat.o(205375);
        return true;
        locala = f.bcy;
        paramInt = f.Bm();
        continue;
        locala = f.bcy;
        paramInt = f.Br();
        continue;
        locala = f.bcy;
        paramInt = f.Bq();
        continue;
        locala = f.bcy;
        paramInt = f.Bp();
        continue;
        locala = f.bcy;
        paramInt = f.si();
        continue;
        locala = f.bcy;
        paramInt = f.sh();
        continue;
        locala = f.bcy;
        paramInt = f.Bo();
      }
    }
    AppMethodBeat.o(205375);
    return bool;
  }
  
  public final boolean performPrivateCommand(String paramString, Bundle paramBundle)
  {
    boolean bool2 = this.isActive;
    boolean bool1 = bool2;
    if (bool2) {
      bool1 = true;
    }
    return bool1;
  }
  
  public final boolean reportFullscreenMode(boolean paramBoolean)
  {
    return false;
  }
  
  public final boolean requestCursorUpdates(int paramInt)
  {
    boolean bool2 = this.isActive;
    boolean bool1 = bool2;
    if (bool2) {
      bool1 = false;
    }
    return bool1;
  }
  
  public final boolean sendKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(205334);
    kotlin.g.b.s.u(paramKeyEvent, "event");
    boolean bool = this.isActive;
    if (bool)
    {
      this.bcZ.h(paramKeyEvent);
      AppMethodBeat.o(205334);
      return true;
    }
    AppMethodBeat.o(205334);
    return bool;
  }
  
  public final boolean setComposingRegion(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205317);
    boolean bool = this.isActive;
    if (bool) {
      a((d)new o(paramInt1, paramInt2));
    }
    AppMethodBeat.o(205317);
    return bool;
  }
  
  public final boolean setComposingText(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(205321);
    boolean bool = this.isActive;
    if (bool) {
      a((d)new p(String.valueOf(paramCharSequence), paramInt));
    }
    AppMethodBeat.o(205321);
    return bool;
  }
  
  public final boolean setSelection(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205330);
    boolean bool = this.isActive;
    if (bool)
    {
      a((d)new q(paramInt1, paramInt2));
      AppMethodBeat.o(205330);
      return true;
    }
    AppMethodBeat.o(205330);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.c.n
 * JD-Core Version:    0.7.0.1
 */