package android.support.v7.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

final class SearchView$6
  implements View.OnClickListener
{
  SearchView$6(SearchView paramSearchView) {}
  
  public final void onClick(View paramView)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    if (paramView == this.ajT.ajb) {
      this.ajT.iA();
    }
    for (;;)
    {
      return;
      if (paramView == this.ajT.ajd)
      {
        this.ajT.iz();
        return;
      }
      if (paramView == this.ajT.ajc)
      {
        this.ajT.iy();
        return;
      }
      SearchView localSearchView;
      SearchableInfo localSearchableInfo;
      if (paramView == this.ajT.aje)
      {
        localSearchView = this.ajT;
        if (localSearchView.ajJ == null) {
          continue;
        }
        localSearchableInfo = localSearchView.ajJ;
      }
      try
      {
        if (localSearchableInfo.getVoiceSearchLaunchWebSearch())
        {
          localObject2 = new Intent(localSearchView.ajp);
          paramView = localSearchableInfo.getSearchActivity();
          if (paramView == null) {}
          for (paramView = (View)localObject1;; paramView = paramView.flattenToShortString())
          {
            ((Intent)localObject2).putExtra("calling_package", paramView);
            localSearchView.getContext().startActivity((Intent)localObject2);
            return;
          }
        }
        if (!localSearchableInfo.getVoiceSearchLaunchRecognizer()) {
          continue;
        }
        paramView = localSearchView.ajq;
        ComponentName localComponentName = localSearchableInfo.getSearchActivity();
        localObject1 = new Intent("android.intent.action.SEARCH");
        ((Intent)localObject1).setComponent(localComponentName);
        PendingIntent localPendingIntent = PendingIntent.getActivity(localSearchView.getContext(), 0, (Intent)localObject1, 1073741824);
        Bundle localBundle = new Bundle();
        if (localSearchView.ajK != null) {
          localBundle.putParcelable("app_data", localSearchView.ajK);
        }
        Intent localIntent = new Intent(paramView);
        int i = 1;
        Object localObject2 = localSearchView.getResources();
        if (localSearchableInfo.getVoiceLanguageModeId() != 0) {}
        for (paramView = ((Resources)localObject2).getString(localSearchableInfo.getVoiceLanguageModeId());; paramView = "free_form")
        {
          if (localSearchableInfo.getVoicePromptTextId() != 0) {}
          for (localObject1 = ((Resources)localObject2).getString(localSearchableInfo.getVoicePromptTextId());; localObject1 = null)
          {
            if (localSearchableInfo.getVoiceLanguageId() != 0) {}
            for (localObject2 = ((Resources)localObject2).getString(localSearchableInfo.getVoiceLanguageId());; localObject2 = null)
            {
              if (localSearchableInfo.getVoiceMaxResults() != 0) {
                i = localSearchableInfo.getVoiceMaxResults();
              }
              localIntent.putExtra("android.speech.extra.LANGUAGE_MODEL", paramView);
              localIntent.putExtra("android.speech.extra.PROMPT", (String)localObject1);
              localIntent.putExtra("android.speech.extra.LANGUAGE", (String)localObject2);
              localIntent.putExtra("android.speech.extra.MAX_RESULTS", i);
              if (localComponentName == null) {}
              for (paramView = localObject3;; paramView = localComponentName.flattenToShortString())
              {
                localIntent.putExtra("calling_package", paramView);
                localIntent.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", localPendingIntent);
                localIntent.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", localBundle);
                localSearchView.getContext().startActivity(localIntent);
                return;
              }
              if (paramView != this.ajT.aiX) {
                break;
              }
              this.ajT.iC();
              return;
            }
          }
        }
        return;
      }
      catch (ActivityNotFoundException paramView) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v7.widget.SearchView.6
 * JD-Core Version:    0.7.0.1
 */