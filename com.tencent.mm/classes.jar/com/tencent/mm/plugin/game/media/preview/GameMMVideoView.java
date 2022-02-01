package com.tencent.mm.plugin.game.media.preview;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.MMVideoView;

public class GameMMVideoView
  extends MMVideoView
{
  public GameMMVideoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GameMMVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GameMMVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void aCw()
  {
    AppMethodBeat.i(41216);
    super.aCw();
    AppMethodBeat.o(41216);
  }
  
  public final boolean cCw()
  {
    AppMethodBeat.i(41217);
    boolean bool = super.cCw();
    AppMethodBeat.o(41217);
    return bool;
  }
  
  public String getFilePath()
  {
    return this.hxQ;
  }
  
  public String getMediaId()
  {
    AppMethodBeat.i(41215);
    String str = super.getMediaId();
    AppMethodBeat.o(41215);
    return str;
  }
  
  public void setFilepath(String paramString)
  {
    AppMethodBeat.i(41214);
    super.setFilepath(paramString);
    AppMethodBeat.o(41214);
  }
  
  public final void showLoading()
  {
    AppMethodBeat.i(41218);
    super.showLoading();
    AppMethodBeat.o(41218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.preview.GameMMVideoView
 * JD-Core Version:    0.7.0.1
 */