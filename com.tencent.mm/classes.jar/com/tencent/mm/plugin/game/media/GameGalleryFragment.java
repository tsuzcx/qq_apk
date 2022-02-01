package com.tencent.mm.plugin.game.media;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public class GameGalleryFragment
  extends Fragment
{
  View mView;
  private int uhv;
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(40905);
    ae.i("MicroMsg.GameGalleryFragment", "onCreateView");
    if (this.mView != null)
    {
      paramLayoutInflater = this.mView;
      AppMethodBeat.o(40905);
      return paramLayoutInflater;
    }
    paramLayoutInflater = paramLayoutInflater.inflate(this.uhv, paramViewGroup);
    AppMethodBeat.o(40905);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(40906);
    ae.i("MicroMsg.GameGalleryFragment", "onViewCreated");
    AppMethodBeat.o(40906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameGalleryFragment
 * JD-Core Version:    0.7.0.1
 */