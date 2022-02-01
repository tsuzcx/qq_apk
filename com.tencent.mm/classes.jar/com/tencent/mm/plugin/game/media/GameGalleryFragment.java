package com.tencent.mm.plugin.game.media;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class GameGalleryFragment
  extends Fragment
{
  private int IxU;
  View mView;
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(40905);
    Log.i("MicroMsg.GameGalleryFragment", "onCreateView");
    if (this.mView != null)
    {
      paramLayoutInflater = this.mView;
      AppMethodBeat.o(40905);
      return paramLayoutInflater;
    }
    paramLayoutInflater = paramLayoutInflater.inflate(this.IxU, paramViewGroup);
    AppMethodBeat.o(40905);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(40906);
    Log.i("MicroMsg.GameGalleryFragment", "onViewCreated");
    AppMethodBeat.o(40906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameGalleryFragment
 * JD-Core Version:    0.7.0.1
 */