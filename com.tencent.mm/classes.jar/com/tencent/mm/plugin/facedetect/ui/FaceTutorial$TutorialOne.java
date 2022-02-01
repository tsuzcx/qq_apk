package com.tencent.mm.plugin.facedetect.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;

@SuppressLint({"ValidFragment"})
public class FaceTutorial$TutorialOne
  extends Fragment
{
  private View jCI;
  private Button rlN;
  private WeakReference<FaceTutorial> rlO;
  
  public FaceTutorial$TutorialOne(FaceTutorial paramFaceTutorial)
  {
    AppMethodBeat.i(104041);
    this.jCI = null;
    this.rlN = null;
    ad.i("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: TutorialTwo constructed");
    this.rlO = new WeakReference(paramFaceTutorial);
    AppMethodBeat.o(104041);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104043);
    ad.i("MicroMsg.FaceTutorialUI.TutorialTwo", "carson: onCreate");
    super.onCreate(paramBundle);
    AppMethodBeat.o(104043);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(104042);
    ad.i("MicroMsg.FaceTutorialUI.TutorialTwo", "carson: onCreateView()");
    this.jCI = paramLayoutInflater.inflate(2131493927, paramViewGroup, false);
    this.rlN = ((Button)this.jCI.findViewById(2131299721));
    this.rlN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(104040);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/facedetect/ui/FaceTutorial$TutorialOne$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (FaceTutorial.TutorialOne.a(FaceTutorial.TutorialOne.this).get() != null)
        {
          paramAnonymousView = (FaceTutorial)FaceTutorial.TutorialOne.a(FaceTutorial.TutorialOne.this).get();
          if (paramAnonymousView.rlK != null) {
            paramAnonymousView.rlK.ctO();
          }
          paramAnonymousView.dismiss();
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/facedetect/ui/FaceTutorial$TutorialOne$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(104040);
          return;
          ad.e("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: lost tutorial instance");
        }
      }
    });
    paramLayoutInflater = this.jCI;
    AppMethodBeat.o(104042);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104044);
    super.onDestroy();
    ad.i("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: TutorialTwo onDestroy");
    AppMethodBeat.o(104044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceTutorial.TutorialOne
 * JD-Core Version:    0.7.0.1
 */